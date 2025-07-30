package languages.murasaki.MurasakiLanguages.core.usecases.email;

import languages.murasaki.MurasakiLanguages.core.gateway.EmailGateway;

public class RenewedSubscriptionUsecaseImpl implements RenewedSubscriptionUsecase{

    private final EmailGateway emailGateway;

    public RenewedSubscriptionUsecaseImpl(EmailGateway emailGateway) {
        this.emailGateway = emailGateway;
    }

    @Override
    public void execute(String email, String payment, String userName, String productName) {
        emailGateway.renewedSubscription(email, payment, userName, productName);
    }
}
