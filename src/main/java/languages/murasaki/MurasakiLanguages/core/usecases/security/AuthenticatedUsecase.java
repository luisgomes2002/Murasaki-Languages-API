package languages.murasaki.MurasakiLanguages.core.usecases.security;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;

public interface AuthenticatedUsecase {

    public UserInfo getAuthenticatedUser();
}
