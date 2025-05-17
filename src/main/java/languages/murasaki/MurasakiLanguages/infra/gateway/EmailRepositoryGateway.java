package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.email.Email;
import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutResponse;
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