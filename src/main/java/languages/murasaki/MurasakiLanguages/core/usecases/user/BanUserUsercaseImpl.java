package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class BanUserUsercaseImpl implements BanUserUsercase{

    private final UserGateway userGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public BanUserUsercaseImpl(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.userGateway = userGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void execute(String userId, boolean ban) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        userGateway.banUser(userId, ban);
    }
}
