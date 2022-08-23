package com.example.service;

import com.example.entity.BsRequest;
import com.example.entity.BsResponse;
import com.example.entity.PayInDukpay;
import com.example.facade.bs2.clients.Bs2RefreshTokenOauthClient;
import com.example.facade.bs2.model.Bs2GetEidStatusResponse;
import com.example.facade.bs2.model.Bs2Pix;
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
     * @param request
     * @return
     */
    public BsResponse fixProblemByEidAndId(BsRequest request) throws InterruptedException {
        //1.参数校验
        if (request == null
                || StringUtils.isEmpty(request.getEid())) {
            log.error("eid参数为空");
            return BsResponse.builder().errorMsg("eid参数为空").build();
        }

        String eId = request.getEid();
        String idempotencyKey = request.getIdempotencyKey();
         boolean idEmptyFlag = StringUtils.isEmpty(idempotencyKey);
         //2.先查询 bs2
        String accessToken = "";
        try {
            accessToken = bs2QueryService.getAccessToken(eId);
        } catch (Exception e) {
            return BsResponse.builder().eId(eId).errorMsg("调bs2 获取token异常").build();
        }

        //调bs2接口 查证
        Bs2GetEidStatusResponse eidStatusResponse = null;
        try {
            eidStatusResponse = bs2QueryService.queryBs2Result(eId,accessToken);
        } catch (Exception e) {
            return BsResponse.builder().eId(eId).errorMsg("调bs2 查证失败").build();
        }

        //校验查证返回结果
        if(eidStatusResponse==null||(!"Efetivado".equals(eidStatusResponse.getStatus()))){
            return BsResponse.builder().eId(eId).errorMsg("查证返回为空或者订单状态不是支付完成").build();
        }

        //获取vendor_transaction_id
         String vendorTransactionId = eidStatusResponse.getTxId();

        //如果vendorId为空 (判断有无幂等键 有的话 根据幂等键去查询 没有的话 报无查询结果)
        //如果vendorId 不为空 (根据vendorId去查询 有结果 判断有无幂等键 有的话校验幂等键)
        PayInDukpay payInDukpay=StringUtils.isEmpty(vendorTransactionId)?
                (idEmptyFlag?null:bs2QueryService.queryPayInDukpayById(idempotencyKey))
                :bs2QueryService.queryPayInDukpayByVendorId(vendorTransactionId);

       return handle( payInDukpay, eId,idempotencyKey,idEmptyFlag, eidStatusResponse);

    }







    private BsResponse handle(PayInDukpay payInDukpay,String eId,String idempotencyKey,boolean idEmptyFlag,Bs2GetEidStatusResponse eidStatusResponse) throws InterruptedException {
        //3.查询为空 直接返回
        if(null==payInDukpay){
            return BsResponse.builder().eId(eId).errorCode("000000").errorMsg("根据幂等键未查询到相关记录").build();
        }
        //4.状态为已settled 直接返回
        if ("SETTLED".equals(payInDukpay.getTransferStatus())) {
            return BsResponse.builder().eId(eId).errorCode("000000").errorMsg("已经是为settled").build();
        }

        //如果传入的幂等键不为空 校验传入的幂等键和查询出来的幂等键是否一致
        if(!idEmptyFlag&&(!idempotencyKey.equals(payInDukpay.getIdempotencyKey()))){
            return BsResponse.builder().eId(eId).errorCode("000000").errorMsg("数据库中的幂等键和传入的幂等键不一致").build();
        }

        //校验查证返回的txiId 和 TransactionId是否一致
        String txId = eidStatusResponse.getTxId();
        if (txId.equals(payInDukpay.getVendorTransactionId())) {
            return BsResponse.builder().eId(eId).errorMsg("查证返回txId和数据库中不一致").build();
        }

        //组装回调报文
        String data = eidStatusResponse.getData();
        double valor = eidStatusResponse.getValor();
        Bs2Pix bs2Pix = Bs2Pix.builder().status("EFETIVADO")
                .endToEndId(eId)
                .txId(txId)
                .value(valor)
                .settledTime(data)
                .payer(Bs2Pix.PixPayer.builder()
                        .cpf("")
                        .name("liquido")
                        .build()).build();
        //回调
        boolean successFlag = bs2RefreshTokenOauthClient.webhookPix(bs2Pix);
        Thread.sleep(2000);
        final PayInDukpay  payInDukpayINfo =
                bs2QueryService.queryPayInDukpayById(payInDukpay.getIdempotencyKey());
        final boolean isSettled = "SETTLED".equals(payInDukpayINfo.getTransferStatus());

        String errorMsg = isSettled ? "已经更新为settled" : (!successFlag?"回调异常":"已回调成功，状态暂时为更新稍后再查");

        return BsResponse.builder().eId(eId).errorCode("000000").errorMsg(errorMsg).build();

    }


}
