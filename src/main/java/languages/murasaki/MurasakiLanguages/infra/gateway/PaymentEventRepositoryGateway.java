package languages.murasaki.MurasakiLanguages.infra.gateway;

import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;

import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutCompletedEvent;
import languages.murasaki.MurasakiLanguages.core.entities.payment.SubscriptionDeletedEvent;
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
    public void processEvent(String payload, String sigHeader) {
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

                handleCheckoutCompleted(new CheckoutCompletedEvent(
                        session.getCustomer(),
                        session.getSubscription()
                ));

                // Recupere dados adicionais
                String customerId = session.getCustomer();
                String subscriptionId = session.getSubscription();

                try {
                    // Obtenha o email do cliente
                    Customer customer = Customer.retrieve(customerId);
                    String email = customer.getEmail();

                    // Obtenha o nome do produto associado à assinatura
                    Subscription subscription = Subscription.retrieve(subscriptionId);
                    SubscriptionItem item = subscription.getItems().getData().get(0); // primeiro item
                    Price price = item.getPrice();
                    Product product = Product.retrieve(price.getProduct());
                    String productName = product.getName();

                    System.out.println("Checkout concluído:");
                    System.out.println("Email do cliente: " + email);
                    System.out.println("Nome do produto: " + productName);
                    System.out.println("Customer ID: " + customerId);
                    System.out.println("Subscription ID: " + subscriptionId);

                    handleCheckoutCompleted(new CheckoutCompletedEvent(customerId, subscriptionId));
                } catch (StripeException e) {
                    throw new RuntimeException("Erro ao buscar dados da Stripe", e);
                }

                break;

            case "customer.subscription.deleted":
                Subscription sub = (Subscription) event.getDataObjectDeserializer()
                        .getObject().orElseThrow();

                handleSubscriptionDeleted(new SubscriptionDeletedEvent(
                        sub.getId(),
                        sub.getCustomer()
                ));
                break;

            default:
                // ignorar ou logar
                break;
        }
    }


    @Override
    public void handleCheckoutCompleted(CheckoutCompletedEvent event) {
        System.out.println("Checkout concluído: Customer ID: " + event.customerId() +
                ", Subscription ID: " + event.subscriptionId());
    }

    @Override
    public void handleSubscriptionDeleted(SubscriptionDeletedEvent event) {
        System.out.println("Assinatura cancelada: Subscription ID: " + event.subscriptionId() +
                ", Customer ID: " + event.customerId());
    }
}
