package languages.murasaki.MurasakiLanguages.core.usecases.plans;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.PlansGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class CreatePlanUsecaseImpl implements CreatePlanUsecase{

    public final PlansGateway plansGateway;
    public final AuthenticatedUsecase authenticatedUsecase;

    public CreatePlanUsecaseImpl(PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.plansGateway = plansGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public Plans execute(Plans plans) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(plans.title() == null || plans.description() == null || plans.value() == null|| plans.advantages() == null) throw new MissingArgumentsException("Campos faltando");

        return plansGateway.createPlan(plans);
    }
}
