package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.usecases.payment.PaymentHandleEventUsecase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhook/stripe")
public class PaymentController {


    private final PaymentHandleEventUsecase paymentHandleEventUsecase;

    public PaymentController(PaymentHandleEventUsecase paymentHandleEventUsecase) {
        this.paymentHandleEventUsecase = paymentHandleEventUsecase;
    }

    @PostMapping
    public ResponseEntity<String> handleStripeEvent(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
        paymentHandleEventUsecase.handleEvent(payload, sigHeader);
        return ResponseEntity.ok("Received");
    }
}
