package languages.murasaki.MurasakiLanguages.infra.gateway;

import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;

import languages.murasaki.MurasakiLanguages.core.entities.payment.PaymentResponse;
import languages.murasaki.MurasakiLanguages.core.enums.PaymentType;
import languages.murasaki.MurasakiLanguages.core.gateway.PaymentGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventRepositoryGateway implements PaymentGateway {

    @Value("${stripe.api-key}")
    private String STRIPE_SECRET_KEY;

    @Value("${stripe.webhook-secret}")
    private String STRIPE_WEBHOOK_SECRET;


    @Override
    public PaymentResponse processEvent(String payload, String sigHeader) {
        Stripe.apiKey = STRIPE_SECRET_KEY;
        Event event;

        try {
            event = Webhook.constructEvent(payload, sigHeader, STRIPE_WEBHOOK_SECRET);
        } catch (SignatureVerificationException e) {
            throw new RuntimeException("Webhook signature verification failed", e);
        }

        switch (event.getType()) {
            case "checkout.session.completed":
                Session session = (Session) event.getDataObjectDeserializer()
                        .getObject().orElseThrow();

                String customerId = session.getCustomer();
                String subscriptionId = session.getSubscription();

                String email;
                String productName;
                String userName;

                try {
                    Customer customer = Customer.retrieve(customerId);
                    email = customer.getEmail();
                    userName = customer.getName();

                    Subscription subscription = Subscription.retrieve(subscriptionId);
                    SubscriptionItem item = subscription.getItems().getData().get(0);
                    Price price = item.getPrice();
                    Product product = Product.retrieve(price.getProduct());
                    productName = product.getName();

                } catch (StripeException e) {
                    throw new RuntimeException("Erro ao buscar dados da Stripe", e);
                }

                return new PaymentResponse(email, productName, userName, PaymentType.COMPLETED);

            case "customer.subscription.deleted":
                Subscription sub = (Subscription) event.getDataObjectDeserializer()
                        .getObject().orElseThrow();

                String customerIdDel = sub.getCustomer();
                String emailDel;

                try {
                    Customer customerDel = Customer.retrieve(customerIdDel);
                    emailDel = customerDel.getEmail();
                } catch (StripeException e) {
                    throw new RuntimeException("Erro ao buscar o cliente da assinatura cancelada", e);
                }

                return new PaymentResponse(emailDel, null, null, PaymentType.DELETED);

            case "invoice.paid":
                Invoice invoice = (Invoice) event.getDataObjectDeserializer()
                        .getObject().orElseThrow();

                String customerIdRenewed = invoice.getCustomer();
                String emailRenewed;

                try {
                    Customer customerRenewed = Customer.retrieve(customerIdRenewed);
                    emailRenewed = customerRenewed.getEmail();
                } catch (StripeException e) {
                    throw new RuntimeException("Erro ao buscar cliente da renovação", e);
                }

                return new PaymentResponse(emailRenewed, null, null, PaymentType.RENEWED);

            default:
                return null;
        }
    }
}
