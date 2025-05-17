package languages.murasaki.MurasakiLanguages.core.usecases.email;

import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutResponse;
import languages.murasaki.MurasakiLanguages.core.gateway.EmailGateway;

public class CompletedSubscriptionUsecaseImpl implements CompletedSubscriptionUsecase{

    private final EmailGateway emailGateway;

    public CompletedSubscriptionUsecaseImpl(EmailGateway emailGateway) {
        this.emailGateway = emailGateway;
    }

    @Override
    public void execute(CheckoutResponse checkoutResponse, String email,String token, boolean accountExist) {
        emailGateway.completedSubscription(checkoutResponse, email, token, accountExist);
    }
}
