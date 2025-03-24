package languages.murasaki.MurasakiLanguages.core.usecases.security;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.SecurityGateway;

public class AuthenticatedUsecaseImpl implements AuthenticatedUsecase{

    private final SecurityGateway securityGateway;

    public AuthenticatedUsecaseImpl(SecurityGateway securityGateway) {
        this.securityGateway = securityGateway;
    }

    @Override
    public UserInfo getAuthenticatedUser() {
       return securityGateway.getAuthenticatedUser();
    }
}
