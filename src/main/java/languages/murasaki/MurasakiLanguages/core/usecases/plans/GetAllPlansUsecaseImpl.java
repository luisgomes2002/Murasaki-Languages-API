package languages.murasaki.MurasakiLanguages.core.usecases.plans;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.PlansGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

import java.util.List;

public class GetAllPlansUsecaseImpl implements GetAllPlansUsecase{

    private final PlansGateway plansGateway;

    public GetAllPlansUsecaseImpl(PlansGateway plansGateway) {
        this.plansGateway = plansGateway;
    }

    @Override
    public List<Plans> execute() {
        return plansGateway.getAllPlans();
    }
}
