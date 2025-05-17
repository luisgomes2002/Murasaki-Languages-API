package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.email.Email;
import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutResponse;

public interface EmailGateway {

    void sendEmail(Email email);
    void completedSubscription(CheckoutResponse checkoutResponse, String email, String token, boolean accountExist);
    void deletedSubscription(String email);
}
