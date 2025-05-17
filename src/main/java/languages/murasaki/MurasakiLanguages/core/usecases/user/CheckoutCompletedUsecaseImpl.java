package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutResponse;
import languages.murasaki.MurasakiLanguages.core.gateway.PaymentGateway;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;

public class CheckoutCompletedUsecaseImpl implements CheckoutCompletedUsecase{

    private final UserGateway userGateway;

    public CheckoutCompletedUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public CheckoutResponse execute(String email, String productName, String userName) {
        return userGateway.checkoutCompleted(email, productName, userName);
    }
}
