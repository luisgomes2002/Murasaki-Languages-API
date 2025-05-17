package languages.murasaki.MurasakiLanguages.core.usecases.payment;

import languages.murasaki.MurasakiLanguages.core.entities.payment.PaymentResponse;
import languages.murasaki.MurasakiLanguages.core.gateway.PaymentGateway;

public class PaymentHandleEventUsecaseImpl implements PaymentHandleEventUsecase {

    private final PaymentGateway paymentGateway;

    public PaymentHandleEventUsecaseImpl(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public PaymentResponse handleEvent(String payload, String sigHeader) {
         return paymentGateway.processEvent(payload, sigHeader);
    }
}
