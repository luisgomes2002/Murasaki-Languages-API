package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutResponse;

public interface CheckoutCompletedUsecase {

    CheckoutResponse execute(String email, String productName, String userName);

}
