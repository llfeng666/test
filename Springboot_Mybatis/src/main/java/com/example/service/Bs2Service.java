package com.example.service;

import java.util.List;
import java.util.Objects;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.entity.BsRequest;
import com.example.entity.BsResponse;
import com.example.entity.PayInDukpay;
import com.example.enums.PayInTableNames;
import com.example.facade.bs2.clients.Bs2RefreshTokenOauthClient;
import com.example.facade.bs2.model.Bs2GetEidStatusResponse;
import com.example.facade.bs2.model.Bs2Pix;
import com.example.facade.bs2.model.Bs2PixPayInRefundRequest;
import com.example.facade.bs2.model.Bs2PixPayInRefundResponse;
import com.example.facade.bs2.model.Bs2QueryRefundResponse;
import com.example.facade.bs2.model.Devolucoes;
import com.example.facade.bs2.model.Pix;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Bs2Service {

    @Autowired
    private Bs2QueryService bs2QueryService;


    @Autowired
    Bs2RefreshTokenOauthClient bs2RefreshTokenOauthClient;

    /**
     * 根据eid调 人家接口
     *
     * @param request 请求入参
     * @return 返回
     */
    public BsResponse fixProblemByEidAndId(BsRequest request) throws Exception {
        //1.参数校验
        if (request == null || StringUtils.isEmpty(request.getE2eId())) {
            log.error("eid参数为空");
            return BsResponse.builder().errorMsg("eid参数为空").build();
        }


        if (Objects.isNull(PayInTableNames.findTableName(request.getCoName()))) {
            log.error("暂不支持传入对商户名称");
            return BsResponse.builder().eId(request.getE2eId()).errorMsg("暂不支持传入对商户名称")
                    .build();
        }
        String tableName = PayInTableNames.findTableName(request.getCoName());


        String e2eId = request.getE2eId();
        String idempotencyKey = request.getIdempotencyKey();
        boolean idEmptyFlag = StringUtils.isEmpty(idempotencyKey);
        //2.先查询 bs2
        String accessToken;
        try {
            accessToken = bs2QueryService.getAccessToken(e2eId);
        } catch (Exception e) {
            log.error("调bs2 获取token 异常");
            return BsResponse.builder().eId(e2eId).errorMsg("调bs2 获取token异常").build();
        }

        //调bs2接口 查证
        Bs2GetEidStatusResponse eidStatusResponse;
        try {
            eidStatusResponse = bs2QueryService.queryBs2Result(e2eId, accessToken);
        } catch (Exception e) {
            log.error("调bs2 查证异常");
            return BsResponse.builder().eId(e2eId).errorMsg("调bs2 查证失败").build();
        }
        log.info("Bs2GetEidStatusResponse:{}",
                (new ObjectMapper()).writeValueAsString(eidStatusResponse));

        //校验查证返回结果
        if (Objects.isNull(eidStatusResponse) ||
                (!"Efetivado".equals(eidStatusResponse.getStatus()))) {
            log.error("bs2查证返回为空或者订单状态不是支付完成");
            return BsResponse.builder().eId(e2eId)
                    .errorMsg("bs2查证返回为空或者订单状态不是支付完成").build();
        }

        //获取vendor_transaction_id
        String vendorTransactionId = eidStatusResponse.getTxId();
        return handle(vendorTransactionId, e2eId, idempotencyKey, idEmptyFlag, eidStatusResponse,
                tableName);

    }


    private BsResponse handle(String vendorTransactionId, String e2eId, String idempotencyKey,
                              boolean idEmptyFlag, Bs2GetEidStatusResponse eidStatusResponse,
                              String tableName) throws Exception {

        PayInDukpay payInDukpay;
        if (!Objects.isNull(vendorTransactionId)) {
            payInDukpay =
                    bs2QueryService.queryPayInDukpayByVendorId(vendorTransactionId, tableName);
        } else {
            if (idEmptyFlag) {
                log.error("vendorId 为空,幂等键为空 无法查询到收款记录");
                return BsResponse.builder().eId(e2eId).errorCode("000000")
                        .errorMsg("vendorId 为空,幂等键为空 无法查询到收款记录").build();
            }
            payInDukpay = bs2QueryService.queryPayInDukpayById(idempotencyKey, tableName);
        }

        if (Objects.isNull(payInDukpay)) {
            log.error("根据幂等键未查询到相关记录");
            return BsResponse.builder().eId(e2eId).errorCode("000000")
                    .errorMsg("根据幂等键未查询到相关记录").build();
        }


        //如果传入的幂等键不为空 校验传入的幂等键和查询出来的幂等键是否一致
        if (!idEmptyFlag && (!idempotencyKey.equals(payInDukpay.getIdempotencyKey()))) {
            log.error("数据库中的幂等键和传入的幂等键不一致");
            return BsResponse.builder().eId(e2eId).errorCode("000000")
                    .errorMsg("数据库中的幂等键和传入的幂等键不一致").build();
        }

        //校验查证返回的txiId 和 TransactionId是否一致
        String txId = eidStatusResponse.getTxId();
        if (!txId.equals(payInDukpay.getVendorTransactionId())) {
            return BsResponse.builder().eId(e2eId).errorMsg("查证返回txId和数据库中不一致").build();
        }

        //校验完再判断状态为已settled 直接返回
        if ("SETTLED".equals(payInDukpay.getTransferStatus())) {
            log.error("已经是为settled");
            return BsResponse.builder().eId(e2eId).errorCode("000000").errorMsg("已经是为settled")
                    .build();
        }

        log.info("开始回调自己");
        //组装回调报文
        String data = eidStatusResponse.getData();
        double valor = eidStatusResponse.getValor();
        Bs2Pix bs2Pix =
                Bs2Pix.builder().status("EFETIVADO").endToEndId(e2eId).txId(txId).valor(valor)
                        .horario(data)
                        .payer(Bs2Pix.PixPayer.builder().cpf("").name("liquido").build()).build();
        final Pix pix = Pix.builder().pix(List.of(bs2Pix)).build();
        log.info("开始回调自己请求入参;{}", new ObjectMapper().writeValueAsString(bs2Pix));
        //回调
        boolean successFlag = bs2RefreshTokenOauthClient.webhookPix(pix);
        Thread.sleep(2000);
        final PayInDukpay payInDukpayInfo =
                bs2QueryService.queryPayInDukpayById(payInDukpay.getIdempotencyKey(), tableName);
        final boolean isSettled = "SETTLED".equals(payInDukpayInfo.getTransferStatus());

        String errorMsg = isSettled ? "已经更新为settled" :
                (!successFlag ? "回调异常" : "已回调成功，状态暂时为更新稍后再查");
        log.info(errorMsg);
        return BsResponse.builder().eId(e2eId).errorCode("000000").errorMsg(errorMsg).build();

    }


    /**
     * 退款逻辑
     *
     * @param request
     * @return
     */
    public BsResponse refund(BsRequest request) {
        String tableName = PayInTableNames.findTableName(request.getCoName());
        if (StrUtil.isEmptyIfStr(tableName)) {
            log.error("商户名称输入有误");
            return BsResponse.builder().errorMsg("商户名称输入有误").build();
        }
        //幂等键 和 e2eid
        final String idempotencyKey = request.getIdempotencyKey();
        final String e2eId = request.getE2eId();
        if (StrUtil.isEmptyIfStr(idempotencyKey) && StrUtil.isEmptyIfStr(e2eId)) {
            log.error("幂等键 或者 e2eid 必输输入一个");
            return BsResponse.builder().errorMsg("幂等键 或者 e2eid 必输输入一个").build();
        }

        final boolean idEmptyFlag = StrUtil.isEmptyIfStr(idempotencyKey);

        //优先根据幂等键去查询
        final PayInDukpay payInDukpay =
                !idEmptyFlag ? bs2QueryService.queryPayInDukpayById(idempotencyKey, tableName) :
                        bs2QueryService.queryPayInDukpayByEId(e2eId, tableName);


        if (Objects.isNull(payInDukpay)) {
            log.error("找不到需要退款的记录");
            return BsResponse.builder().errorMsg("找不到需要退款的记录").build();
        }

        if (!"SETTLED".equals(payInDukpay.getTransferStatus())) {
            log.error("不是settled状态");
            return BsResponse.builder().errorMsg("不是settled状态").build();
        }
        //幂等键不为空 去校验e2eid 查询出来的  为空校验幂等键
        if (!idEmptyFlag && !StrUtil.isEmptyIfStr(e2eId) &&
                !e2eId.equals(payInDukpay.getEndToEndId())) {
            log.error("e2eId和表中的e2eId不一致");
            return BsResponse.builder().errorMsg("e2eId和表中的e2eId不一致").build();
        }

        final String accessToken;
        //执行退款逻辑
        try {
            accessToken = bs2QueryService.getAccessToken(payInDukpay.getEndToEndId());
        } catch (Exception e) {
            log.error("获取token异常");
            return BsResponse.builder().errorMsg("获取token异常").build();
        }

        final Bs2GetEidStatusResponse eidStatusResponse;
        try {
            eidStatusResponse =
                    bs2QueryService.queryBs2Result(payInDukpay.getEndToEndId(), accessToken);
        } catch (Exception e) {
            log.error("查证bs2异常");
            return BsResponse.builder().errorMsg("查证bs2异常").build();
        }
        final double valor = eidStatusResponse.getValor();
        //调退款接口
        String invalidStr = "Bearer " + accessToken;
        final Bs2PixPayInRefundRequest bs2PixPayInRefundRequest =
                Bs2PixPayInRefundRequest.builder().amount(valor).build();
        final Bs2PixPayInRefundResponse refund =
                bs2RefreshTokenOauthClient.refund(e2eId, invalidStr, bs2PixPayInRefundRequest);

        //需要查看下
        return BsResponse.builder().errorMsg("退款成功").build();


    }


    public BsResponse queryRefund(String e2eId) {
        final String accessToken = bs2QueryService.getAccessToken(e2eId);
        final String invalidStr =
                "Bearer " + accessToken;
        final Bs2QueryRefundResponse bs2QueryRefundResponse =
                bs2RefreshTokenOauthClient.queryRefund(e2eId, invalidStr);
        if (ObjectUtil.isNull(bs2QueryRefundResponse.getDevolucoes())) {
            return BsResponse.builder().errorMsg("还没处理完").build();
        }
        final List<Devolucoes> devolucoes = bs2QueryRefundResponse.getDevolucoes();
        if ("DEVOLVIDO".equals(devolucoes.get(0).getStatus())) {
            return BsResponse.builder().errorMsg("处理成功").build();
        }

        return BsResponse.builder().errorMsg("还没处理完").build();

    }




}
