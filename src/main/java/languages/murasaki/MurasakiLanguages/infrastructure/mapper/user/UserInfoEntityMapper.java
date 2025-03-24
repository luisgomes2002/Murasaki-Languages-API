package languages.murasaki.MurasakiLanguages.infrastructure.mapper.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.infrastructure.dtos.user.UserInfoDto;
import languages.murasaki.MurasakiLanguages.infrastructure.persistence.user.UserInfoEntity;
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
