package com.example.service;

import com.example.entity.BsFixByEidRequest;
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

        if (request == null
                || StringUtils.isEmpty(request.getEid())
                || StringUtils.isEmpty(request.getIdempotencyKey())) {
            log.error("参数输入有误");
            return BsResponse.builder().errorMsg("参数输入有误").build();
        }
        String eid = request.getEid();
        String idempotencyKey = request.getIdempotencyKey();

        //2.查询数据库 pay_in_dukpay 获取  vendorTransactionId
        PayInDukpay payInDukpay = bs2QueryService.queryPayInDukpayById(idempotencyKey);
       return handle( payInDukpay, eid);

    }


    public BsResponse fixProblemByEidAndId(BsFixByEidRequest request) throws InterruptedException {

        if (request == null
                || StringUtils.isEmpty(request.getEid())) {
            log.error("Eid参数必输");
            return BsResponse.builder().errorMsg("参数输入有误").build();
        }
        String eid = request.getEid();

        //2.查询数据库 pay_in_dukpay 获取  vendorTransactionId
        PayInDukpay payInDukpay = bs2QueryService.queryPayInDukpayByEId(eid);
        return handle(payInDukpay,eid);


    }




    private BsResponse handle(PayInDukpay payInDukpay,String eId) throws InterruptedException {
        if(null==payInDukpay){
            return BsResponse.builder().eId(eId).errorCode("000000").errorMsg("根据eid 或者 id 未查询到相关记录").build();
        }

        if ("SETTLED".equals(payInDukpay.getTransferStatus())) {
            return BsResponse.builder().eId(eId).errorCode("000000").errorMsg("已经更新为settled").build();
        }

        Bs2GetEidStatusResponse eidStatusResponse = null;
        try {
            eidStatusResponse = bs2QueryService.queryBs2Result(eId);
        } catch (Exception e) {
            return BsResponse.builder().eId(eId).errorMsg(e.getMessage()).build();
        }

        String vendorTransactionId = payInDukpay.getVendorTransactionId();

        String data = eidStatusResponse.getData();
        double valor = eidStatusResponse.getValor();
        //组装回调报文
        Bs2Pix bs2Pix = Bs2Pix.builder().status("EFETIVADO")
                .endToEndId(eId)
                .txId(vendorTransactionId)
                .value(valor)
                .settledTime(data)
                .payer(Bs2Pix.PixPayer.builder()
                        .cpf("")
                        .name("liquido")
                        .build()).build();
        boolean successFlag = bs2RefreshTokenOauthClient.webhookPix(bs2Pix);
        Thread.sleep(2000);
        final PayInDukpay  payInDukpayINfo =
                bs2QueryService.queryPayInDukpayById(payInDukpay.getIdempotencyKey());
        final boolean isSettled = "SETTLED".equals(payInDukpayINfo.getTransferStatus());

        String errorMsg = isSettled ? "已经更新为settled" : (!successFlag?"回调异常":"已回调成功，状态暂时为更新稍后再查");

        return BsResponse.builder().eId(eId).errorCode("000000").errorMsg(errorMsg).build();

    }


}
