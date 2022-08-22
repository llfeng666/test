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

        String eid = request.getEid();
        String idempotencyKey = request.getIdempotencyKey();
         boolean idEmptyFlag = StringUtils.isEmpty(idempotencyKey);
        //2. 查询数据库 pay_in_dukpay 获取  vendorTransactionId
        PayInDukpay payInDukpay =  idEmptyFlag ?
                bs2QueryService.queryPayInDukpayByEId(eid)
                :bs2QueryService.queryPayInDukpayById(idempotencyKey);
       return handle( payInDukpay, eid,idEmptyFlag);

    }







    private BsResponse handle(PayInDukpay payInDukpay,String eId,boolean idEmptyFlag) throws InterruptedException {
        //3.查询为空 直接返回
        if(null==payInDukpay){
            return BsResponse.builder().eId(eId).errorCode("000000").errorMsg(idEmptyFlag?"根据eid未查询到相关记录":"根据幂等键未查询到相关记录").build();
        }
        //4.状态为已settled 直接返回
        if ("SETTLED".equals(payInDukpay.getTransferStatus())) {
            return BsResponse.builder().eId(eId).errorCode("000000").errorMsg("已经是为settled").build();
        }

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

        //校验查证返回的txid 和 TransactionId是否一致
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
