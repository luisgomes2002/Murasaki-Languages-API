package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.enums.UserType;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class UpdateUserTypeUsecaseImpl implements UpdateUserTypeUsecase{

    private final UserGateway userGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public UpdateUserTypeUsecaseImpl(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.userGateway = userGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void execute(String id, UserType type) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        userGateway.updateUserType(id, type);
    }
}
