package languages.murasaki.MurasakiLanguages.core.usecases.plans;

import languages.murasaki.MurasakiLanguages.core.entities.plans.Plans;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.PlansGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class GetPlanByIdUsecaseImpl implements GetPlanByIdUsecase{

    private final PlansGateway plansGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetPlanByIdUsecaseImpl(PlansGateway plansGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.plansGateway = plansGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public Plans execute(String id) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return plansGateway.getPlanById(id);
    }
}
