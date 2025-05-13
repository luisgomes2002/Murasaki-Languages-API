package languages.murasaki.MurasakiLanguages.infra.presentation;

import languages.murasaki.MurasakiLanguages.core.usecases.subscription.CreateSubscriptionUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/subscription/")
public class SubscriptionController {

    private final CreateSubscriptionUsecase createSubscriptionUsecase;

    public SubscriptionController(CreateSubscriptionUsecase createSubscriptionUsecase) {
        this.createSubscriptionUsecase = createSubscriptionUsecase;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createSubscription(@RequestBody String planId) {
        String result = createSubscriptionUsecase.execute(planId);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Assinatura criada", "mercadoPagoResponse", result));
    }
}
