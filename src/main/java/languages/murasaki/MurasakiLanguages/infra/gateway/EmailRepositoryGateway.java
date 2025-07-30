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
            <p>Olá! 🎉</p>

            <p>Sua assinatura foi confirmada com sucesso!</p>

            <p>Se tiver qualquer dúvida ou precisar de ajuda, estamos aqui para te atender.</p>

            <p>Aproveite ao máximo sua experiência com a gente!</p>

            <p>Atenciosamente,<br>
            Equipe Murasaki Languages.</p>
            """;

            sendEmail(new Email(email, "Assinatura Confirmada!", body));
        } else {
            createSubscription(email, token, checkoutResponse);
        }
    }

    private void createSubscription(String email, String token, CheckoutResponse checkoutResponse) {
        String confirmationLink = "http://localhost:5173/confirm?token=" + token;

        System.out.println(token);

        String body = String.format("""
            <p>Olá! 🎉</p>

            <p>Obrigado por assinar um de nossos planos!</p>

            <p>Sua assinatura foi confirmada com sucesso. Agora você tem acesso aos benefícios exclusivos do seu plano.</p>

            <p><strong>Sua senha de acesso:</strong> %s<br>

            <p>Se tiver qualquer dúvida ou precisar de ajuda, estamos aqui para te atender.</p>

            <p>Atenciosamente,<br>
            Equipe Murasaki Languages.</p>
            """, checkoutResponse.password(), confirmationLink, confirmationLink);

        Email newEmail = new Email(email, "Assinatura Confirmada!", body);
        sendEmail(newEmail);
    }

    @Override
    public void deletedSubscription(String email) {
        String body = """
        <p>Olá! 😢</p>

        <p>Sentiremos sua falta!</p>

        <p>Sua assinatura foi cancelada com sucesso, mas queremos que saiba que foi um prazer ter você com a gente durante esse tempo.</p>

        <p>Se precisar de qualquer coisa ou quiser voltar, estaremos de portas abertas!</p>

        <p>Com carinho,<br>
        Equipe Murasaki.</p>
        """;

        sendEmail(new Email(email, "Até breve!", body));
    }

    @Override
    public void renewedSubscription(String email, String payment, String userName, String productName) {
        String body = String.format("""
        <p>Olá, %s!</p>

        <p>Confirmamos o pagamento da sua assinatura do plano "<strong>%s</strong>". 🎉</p>

        <p>Aqui estão os detalhes do seu pagamento:</p>

        <ul>
            <li>👤 <strong>Nome do assinante:</strong> %s</li>
            <li>📦 <strong>Plano:</strong> %s</li>
            <li>📅 <strong>Data da renovação:</strong> %s</li>
        </ul>

        <p>Se tiver qualquer dúvida ou precisar de ajuda, é só nos chamar!</p>

        <p>Atenciosamente,<br>
        Equipe Murasaki Languages.</p>
        """,
                userName,
                productName,
                userName,
                productName,
                java.time.LocalDate.now().toString()
        );

        sendEmail(new Email(email, "Assinatura Renovada com Sucesso!", body));
    }



}