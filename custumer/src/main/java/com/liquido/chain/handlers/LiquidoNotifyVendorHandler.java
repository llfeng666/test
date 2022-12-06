package com.liquido.chain.handlers;

import java.util.List;
import java.util.Objects;

import com.liquido.chain.Bs2HanlderChain;
import com.liquido.chain.Bs2ProcessRequest;
import com.liquido.chain.TradeContext;
import com.liquido.chain.handlers.vo.Bs2ProcessData;
import com.liquido.chain.handlers.vo.TradeTypeClassName;
import com.liquido.facade.bs2.clients.Bs2RefreshTokenOauthClient;
import com.liquido.facade.bs2.model.Bs2GetEidStatusResponse;
import com.liquido.facade.bs2.model.Bs2Pix;
import com.liquido.facade.bs2.model.Bs2QueryTransactionByVendorIdResponse;
import com.liquido.facade.bs2.model.Bs2VendorResponsePix;
import com.liquido.facade.bs2.model.Pix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("liquidoNotifyVendorHandler")
public class LiquidoNotifyVendorHandler implements Bs2HanlderChain {

    @Autowired
    private Bs2RefreshTokenOauthClient bs2RefreshTokenOauthClient;

    @Override
    public TradeContext process(Chain<Bs2ProcessRequest, TradeContext> chain) {
        TradeContext response = chain.response();
        final Bs2ProcessRequest request = chain.request();
        Bs2ProcessData bs2ProcessData = response.getBs2ProcessData();
        boolean failedFlag = false;
        String errorMsg = "";
        final Pix pix = prepareRequestParam(request,bs2ProcessData);
        log.info("开始回调自己请求入参;{}", pix);
        try {
            bs2RefreshTokenOauthClient.webhookPix(pix);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return response.setContext(response,failedFlag,
                TradeTypeClassName.bs2E2eIdQueryHandler.name(),
                errorMsg,
                bs2ProcessData
                );
    }


    private Pix prepareRequestParam(Bs2ProcessRequest request ,Bs2ProcessData bs2ProcessData ){
        final Bs2GetEidStatusResponse bs2GetEidStatusResponse =
                bs2ProcessData.getBs2GetEidStatusResponse();
        final boolean e2eResponseEmpty = Objects.isNull(bs2GetEidStatusResponse);

        String data ;
        double valor ;
        String endToEndId ;
        final String txId ;
        if(!e2eResponseEmpty){
           data = bs2GetEidStatusResponse.getData();
           valor = bs2GetEidStatusResponse.getValor();
           endToEndId = bs2GetEidStatusResponse.getEndToEndId();
           txId = bs2GetEidStatusResponse.getTxId();
        }else{
            final Bs2QueryTransactionByVendorIdResponse bs2QueryTransactionByVendorIdResponse =
                    bs2ProcessData.getBs2QueryTransactionByVendorIdResponse();
            txId = request.getVendorTransactionId();
            final Bs2VendorResponsePix bs2VendorResponsePix =
                    bs2QueryTransactionByVendorIdResponse.getPix().stream()
                            .filter(e -> txId.equals(e.getTxId())).findFirst().get();
            valor = bs2VendorResponsePix.getValor();
            endToEndId = bs2VendorResponsePix.getEndToEndId();
            data = bs2VendorResponsePix.getHorario();
        }

        Bs2Pix bs2Pix =
                Bs2Pix.builder().status("EFETIVADO").endToEndId(endToEndId).txId(txId).valor(valor)
                        .horario(data)
                        .payer(Bs2Pix.PixPayer.builder().cpf("").name("liquido").build()).build();
        return Pix.builder().pix(List.of(bs2Pix)).build();
    }

}
