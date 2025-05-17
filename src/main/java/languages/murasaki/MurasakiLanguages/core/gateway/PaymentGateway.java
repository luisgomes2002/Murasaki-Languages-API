package languages.murasaki.MurasakiLanguages.core.gateway;


import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutCompletedEvent;
import languages.murasaki.MurasakiLanguages.core.entities.payment.SubscriptionDeletedEvent;

public interface PaymentGateway {

    void processEvent(String payload, String sigHeader);

    void handleCheckoutCompleted(CheckoutCompletedEvent event);
    void handleSubscriptionDeleted(SubscriptionDeletedEvent event);

}
