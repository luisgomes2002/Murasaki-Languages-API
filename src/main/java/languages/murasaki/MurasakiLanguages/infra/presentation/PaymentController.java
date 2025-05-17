package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutResponse;
import languages.murasaki.MurasakiLanguages.core.entities.payment.PaymentResponse;
import languages.murasaki.MurasakiLanguages.core.enums.PaymentType;
import languages.murasaki.MurasakiLanguages.core.usecases.email.CompletedSubscriptionUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.email.DeletedSubscriptionUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.email.RenewedSubscriptionUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.generatetoken.GenerateAndStoreTokenUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.payment.PaymentHandleEventUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.user.CheckoutCompletedUsecase;
import languages.murasaki.MurasakiLanguages.core.usecases.user.SubscriptionDeletedUsecase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhook/stripe")
public class PaymentController {

    private final CheckoutCompletedUsecase checkoutCompletedUsecase;
    private final PaymentHandleEventUsecase paymentHandleEventUsecase;
    private final CompletedSubscriptionUsecase completedSubscriptionUsecase;
    private final DeletedSubscriptionUsecase deletedSubscriptionEmailUsecase;
    private final GenerateAndStoreTokenUsecase generateAndStoreTokenUsecase;
    private final SubscriptionDeletedUsecase subscriptionDeletedUsecase;
    private final RenewedSubscriptionUsecase renewedSubscriptionUsecase;

    public PaymentController(CheckoutCompletedUsecase checkoutCompletedUsecase, PaymentHandleEventUsecase paymentHandleEventUsecase, CompletedSubscriptionUsecase completedSubscriptionUsecase, DeletedSubscriptionUsecase deletedSubscriptionEmailUsecase, GenerateAndStoreTokenUsecase generateAndStoreTokenUsecase, SubscriptionDeletedUsecase subscriptionDeletedUsecase, RenewedSubscriptionUsecase renewedSubscriptionUsecase) {
        this.checkoutCompletedUsecase = checkoutCompletedUsecase;
        this.paymentHandleEventUsecase = paymentHandleEventUsecase;
        this.completedSubscriptionUsecase = completedSubscriptionUsecase;
        this.deletedSubscriptionEmailUsecase = deletedSubscriptionEmailUsecase;
        this.generateAndStoreTokenUsecase = generateAndStoreTokenUsecase;
        this.subscriptionDeletedUsecase = subscriptionDeletedUsecase;
        this.renewedSubscriptionUsecase = renewedSubscriptionUsecase;
    }

    @PostMapping
    public ResponseEntity<String> handleStripeEvent(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
        PaymentResponse paymentResponse = paymentHandleEventUsecase.handleEvent(payload, sigHeader);

        if (paymentResponse == null) {
            return ResponseEntity.ok("Evento ignorado");
        }

        if(paymentResponse.paymentType().equals(PaymentType.COMPLETED)) {
            CheckoutResponse response = checkoutCompletedUsecase.execute(paymentResponse.email(), paymentResponse.productName(), paymentResponse.userName());
            String token = generateAndStoreTokenUsecase.execute(response.userId());
            completedSubscriptionUsecase.execute(response, paymentResponse.email(), token, response.accountExist());
        }

        if(paymentResponse.paymentType().equals(PaymentType.DELETED)) {
            subscriptionDeletedUsecase.execute(paymentResponse.email());
            deletedSubscriptionEmailUsecase.execute(paymentResponse.email());
        }

        if(paymentResponse.paymentType().equals(PaymentType.RENEWED)) {
            renewedSubscriptionUsecase.execute(paymentResponse.email());
        }


        return ResponseEntity.ok("Received");
    }
}
