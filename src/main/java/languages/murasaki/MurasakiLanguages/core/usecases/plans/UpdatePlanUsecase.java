package languages.murasaki.MurasakiLanguages.core.usecases.plans;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;

public interface UpdatePlanUsecase {

    Plans execute(String planId, Plans plan);
}
