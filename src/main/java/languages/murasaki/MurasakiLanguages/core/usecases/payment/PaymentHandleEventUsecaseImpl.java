package languages.murasaki.MurasakiLanguages.core.usecases.payment;

import languages.murasaki.MurasakiLanguages.core.gateway.PaymentGateway;

public class PaymentHandleEventUsecaseImpl implements PaymentHandleEventUsecase {

    private final PaymentGateway paymentGateway;

    public PaymentHandleEventUsecaseImpl(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void handleEvent(String payload, String sigHeader) {
            paymentGateway.processEvent(payload, sigHeader);
    }
}
