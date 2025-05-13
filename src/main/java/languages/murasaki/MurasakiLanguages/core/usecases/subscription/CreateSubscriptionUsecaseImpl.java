package languages.murasaki.MurasakiLanguages.core.usecases.subscription;

import languages.murasaki.MurasakiLanguages.core.gateway.SubscriptionGateway;

public class CreateSubscriptionUsecaseImpl implements CreateSubscriptionUsecase {

    private final SubscriptionGateway subscriptionGateway;

    public CreateSubscriptionUsecaseImpl(SubscriptionGateway subscriptionGateway) {
        this.subscriptionGateway = subscriptionGateway;
    }

    @Override
    public String execute(String planId) {

        // TODO: Verificar se o usuario esta logado

        return subscriptionGateway.createSubscription(planId);
    }
}
