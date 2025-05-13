package languages.murasaki.MurasakiLanguages.infra.mapper.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.infra.persistence.user.UserInfoEntity;
import org.springframework.stereotype.Component;

@Component
public class UserInfoEntityMapper {

    public UserInfoEntity toEntity(UserInfo userInfo){
        return new UserInfoEntity(
            userInfo.userId(),
            userInfo.name(),
            userInfo.userType(),
            userInfo.email(),
            userInfo.subscription()
        );
    }

    public UserInfo toDomain(UserInfoEntity userInfoEntity){
        return new UserInfo(
            userInfoEntity.getUserId(),
            userInfoEntity.getName(),
            userInfoEntity.getUserType(),
            userInfoEntity.getEmail(),
            userInfoEntity.getSubscription()
        );
    }

}
