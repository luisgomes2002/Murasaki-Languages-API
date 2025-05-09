package languages.murasaki.MurasakiLanguages.core.usecases.email;

import languages.murasaki.MurasakiLanguages.core.entities.email.Email;
import languages.murasaki.MurasakiLanguages.core.gateway.EmailGateway;

public class SendEmailUsecaseImpl implements SendEmailUsecase{

    private final EmailGateway emailGateway;

    public SendEmailUsecaseImpl(EmailGateway emailGateway) {
        this.emailGateway = emailGateway;
    }

    @Override
    public void execute(Email email) {
         emailGateway.sendEmail(email);
    }
}
