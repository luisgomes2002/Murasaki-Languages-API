package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;

public interface SecurityGateway {

    UserInfo getAuthenticatedUser();
}
