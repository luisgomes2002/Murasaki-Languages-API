package languages.murasaki.MurasakiLanguages.core.usecases.plans;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;

import java.util.List;

public interface GetAllPlansUsecase {

    List<Plans> execute();
}
