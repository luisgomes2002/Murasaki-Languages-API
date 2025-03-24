package languages.murasaki.MurasakiLanguages.infra.mapper.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.infra.persistence.user.UserInfoEntity;
import org.springframework.stereotype.Component;

@Component
public class UserInfoEntityMapper {

    public UserInfoEntity toDto(UserInfo userInfo){
        return new UserInfoEntity(
            userInfo.userId(),
            userInfo.username(),
            userInfo.userType(),
            userInfo.email()
        );
    }

    public UserInfo toDomain(UserInfoEntity userInfoEntity){
        return new UserInfo(
            userInfoEntity.getUserId(),
            userInfoEntity.getUsername(),
            userInfoEntity.getUserType(),
            userInfoEntity.getEmail()
        );
    }

}
