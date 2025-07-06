package languages.murasaki.MurasakiLanguages.infra.gateway;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import languages.murasaki.MurasakiLanguages.core.entities.email.Email;
import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutResponse;
import languages.murasaki.MurasakiLanguages.core.gateway.EmailGateway;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailRepositoryGateway implements EmailGateway {

    private final JavaMailSender mailSender;

    public EmailRepositoryGateway(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(Email email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("murasakilanguages@gmail.com");
            helper.setTo(email.email());
            helper.setSubject(email.subject());
            helper.setText(email.text(), true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Erro ao enviar e-mail HTML", e);
        }
    }

    @Override
    public void completedSubscription(CheckoutResponse checkoutResponse, String email, String token, boolean accountExist) {
        if (accountExist) {
            String body = """
            Olá! 🎉

            Sua assinatura foi confirmada com sucesso!

            Se tiver qualquer dúvida ou precisar de ajuda, estamos aqui para te atender.

            Aproveite ao máximo sua experiência com a gente!

            Atenciosamente,
            Equipe Murasaki Languages.
            """;

            sendEmail(new Email(email, "Assinatura Confirmada!", body));
        } else {
            createSubscription(email, token, checkoutResponse);
        }
    }

    private void createSubscription(String email, String token, CheckoutResponse checkoutResponse) {
        String confirmationLink = "http://localhost:8080/api/confirm?token=" + token;

        String body = String.format("""
                Olá! 🎉

                Obrigado por assinar um de nossos planos!

                Sua assinatura foi confirmada com sucesso. Agora você tem acesso aos benefícios exclusivos do seu plano.

                Sua senha de acesso: %s
                Por favor, confirme seu e-mail: %s

                Se tiver qualquer dúvida ou precisar de ajuda, estamos aqui para te atender.

                Atenciosamente,
                Equipe Murasaki Languages.
                """, checkoutResponse.password(), confirmationLink);

        Email newEmail = new Email(email, "Assinatura Confirmada!", body);
        sendEmail(newEmail);
    }

    @Override
    public void deletedSubscription(String email) {
        String body = """
            Olá! 😢

            Sentiremos sua falta!

            Sua assinatura foi cancelada com sucesso, mas queremos que saiba que foi um prazer ter você com a gente durante esse tempo.

            Se precisar de qualquer coisa ou quiser voltar, estaremos de portas abertas!

            Com carinho,
            Equipe Murasaki.
            """;

        sendEmail(new Email(email, "Até breve!", body));
    }

    @Override
    public void renewedSubscription(String email) {
        String body = """
        NOTA FISCAL
       
        Equipe Murasaki Languages.
        """;

        sendEmail(new Email(email, "Assinatura Renovada com Sucesso!", body));
    }


}