package languages.murasaki.MurasakiLanguages.core.usecases.email;

import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutResponse;

public interface CompletedSubscriptionUsecase {

    void execute(CheckoutResponse checkoutResponse, String email, String token, boolean accountExist);
}
