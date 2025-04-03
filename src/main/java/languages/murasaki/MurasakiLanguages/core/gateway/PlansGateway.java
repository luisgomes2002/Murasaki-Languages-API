package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;

import java.util.List;

public interface PlansGateway {

    Plans createPlan(Plans plans);
    List<Plans> getAllPlans();
    Plans getPlanById(String id);
    Plans updatePlan(String id, Plans plan);

    void deletePlan(String id);

}
