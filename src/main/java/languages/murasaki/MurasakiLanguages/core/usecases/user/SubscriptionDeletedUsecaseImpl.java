package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;

public class SubscriptionDeletedUsecaseImpl implements SubscriptionDeletedUsecase{

    private final UserGateway userGateway;

    public SubscriptionDeletedUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void execute(String email) {
        userGateway.SubscriptionDeleted(email);
    }
}
