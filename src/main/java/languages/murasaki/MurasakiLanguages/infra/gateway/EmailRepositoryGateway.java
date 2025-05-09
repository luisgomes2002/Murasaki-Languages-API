package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.email.Email;
import languages.murasaki.MurasakiLanguages.core.gateway.EmailGateway;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailRepositoryGateway implements EmailGateway {

    private final JavaMailSender mailSender;

    public EmailRepositoryGateway(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("murasakilanguages@gmail.com");
        message.setTo(email.email());
        message.setSubject(email.subject());
        message.setText(email.text());

        mailSender.send(message);
    }
}