package languages.murasaki.MurasakiLanguages.core.usecases.payment;

import languages.murasaki.MurasakiLanguages.core.entities.payment.PaymentResponse;

public interface PaymentHandleEventUsecase {

    PaymentResponse handleEvent(String payload, String sigHeader);
}
