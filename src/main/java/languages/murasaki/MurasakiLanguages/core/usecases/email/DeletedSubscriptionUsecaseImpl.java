package languages.murasaki.MurasakiLanguages.core.usecases.email;

import languages.murasaki.MurasakiLanguages.core.gateway.EmailGateway;

public class DeletedSubscriptionUsecaseImpl implements DeletedSubscriptionUsecase{

    private final EmailGateway emailGateway;

    public DeletedSubscriptionUsecaseImpl(EmailGateway emailGateway) {
        this.emailGateway = emailGateway;
    }

    @Override
    public void execute(String email) {
        emailGateway.deletedSubscription(email);
    }
}
