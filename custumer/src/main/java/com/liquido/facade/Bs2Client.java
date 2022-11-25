package com.liquido.facade;

import com.liquido.facade.bs2.model.Bs2BoletoCancelResponse;
import com.liquido.facade.bs2.model.Bs2BoletoCreateRequest;
import com.liquido.facade.bs2.model.Bs2BoletoCreateResponse;
import com.liquido.facade.bs2.model.Bs2BoletoQueryResponse;
import com.liquido.facade.bs2.model.Bs2PixPayInCreateDynamicQrCodeRequest;
import com.liquido.facade.bs2.model.Bs2PixPayInCreateDynamicQrCodeResponse;
import com.liquido.facade.bs2.model.Bs2PixPayInCreateQrCodeRequest;
import com.liquido.facade.bs2.model.Bs2PixPayInCreateQrCodeResponse;
import com.liquido.facade.bs2.model.Bs2PixPayInRefundRequest;
import com.liquido.facade.bs2.model.Bs2PixPayInRefundResponse;
import com.liquido.facade.bs2.model.Bs2PixQrCodeQueryResponse;
import com.liquido.facade.bs2.model.Bs2PixQueryTransactionResponse;

public interface Bs2Client {
    Bs2PixPayInCreateQrCodeResponse pixPayInCreateStaticQrCode(Bs2PixPayInCreateQrCodeRequest req);

    Bs2PixPayInCreateDynamicQrCodeResponse pixPayInCreateDynamicQrCode(
            Bs2PixPayInCreateDynamicQrCodeRequest req);

    Bs2PixPayInRefundResponse pixRequestRefund(
            String originalPaymentE2eId, String refundTxIdToUse, Bs2PixPayInRefundRequest req);

    Bs2PixPayInRefundResponse pixQueryRefund(String originalPaymentE2eId, String refundTxId);

    Bs2PixQueryTransactionResponse pixQueryTransaction(String txId);

    Bs2PixQrCodeQueryResponse pixQueryQrCode(String txId);

    void pixCancelQrCode(int qrCodeId);

    Bs2BoletoCreateResponse boletoCreate(Bs2BoletoCreateRequest req);

    Bs2BoletoQueryResponse boletoQueryTransaction(String bs2BoletoNumber);

    Bs2BoletoCancelResponse boletoCancel(String bs2BoletoNumber);
}
