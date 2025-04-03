package languages.murasaki.MurasakiLanguages.core.usecases.plans;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;

public interface GetPlanByIdUsecase {

    Plans execute(String id);
}
