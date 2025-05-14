package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;
import languages.murasaki.MurasakiLanguages.core.gateway.PlansGateway;
import languages.murasaki.MurasakiLanguages.core.gateway.SubscriptionGateway;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionRepositoryGateway implements SubscriptionGateway {

    private final PlansGateway plansGateway;

    public SubscriptionRepositoryGateway(PlansGateway plansGateway) {
        this.plansGateway = plansGateway;
    }

    @Override
    public String createSubscription(String planId) {
        Plans plan = plansGateway.getPlanById(planId);

        return createCheckoutUrl(plan.id());
    }

    private String createCheckoutUrl(String preapprovalPlanId) {
        return "https://www.mercadopago.com.br/subscriptions/checkout?preapproval_plan_id=" + preapprovalPlanId;
    }

}
