package languages.murasaki.MurasakiLanguages.infra.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.SecurityGateway;
import languages.murasaki.MurasakiLanguages.infra.mapper.user.UserInfoEntityMapper;
import languages.murasaki.MurasakiLanguages.infra.persistence.user.UserInfoEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityRepositoryGateway implements SecurityGateway {

    private final UserInfoEntityMapper userInfoEntityMapper;

    public SecurityRepositoryGateway(UserInfoEntityMapper userInfoEntityMapper) {
        this.userInfoEntityMapper = userInfoEntityMapper;
    }

    @Override
    public UserInfo getAuthenticatedUser() {
        UserInfoEntity user = (UserInfoEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userInfoEntityMapper.toDomain(user);
    }
}
