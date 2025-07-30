package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class GetUserByIdUsecaseImpl implements GetUserByIdUsecase{

    private final UserGateway userGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetUserByIdUsecaseImpl(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.userGateway = userGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public User execute(String id) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        return userGateway.getUserById(id);
    }
}
