package languages.murasaki.MurasakiLanguages.core.usecases.email;

import languages.murasaki.MurasakiLanguages.core.entities.email.Email;

public interface SendEmailUsecase {

    public void execute(Email email);
}
