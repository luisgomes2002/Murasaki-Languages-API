package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.email.Email;

public interface EmailGateway {

    void sendEmail(Email email);
}
