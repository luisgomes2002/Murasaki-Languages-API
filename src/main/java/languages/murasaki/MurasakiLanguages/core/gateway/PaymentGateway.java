package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.payment.PaymentResponse;

public interface PaymentGateway {

    PaymentResponse processEvent(String payload, String sigHeader);
}
