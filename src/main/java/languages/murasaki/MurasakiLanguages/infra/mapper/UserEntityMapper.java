package languages.murasaki.MurasakiLanguages.infra.mapper;

import languages.murasaki.MurasakiLanguages.core.entities.User;
import languages.murasaki.MurasakiLanguages.infra.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user){
        return new UserEntity(
            user.id(),
            user.name(),
            user.username(),
            user.email(),
            user.password(),
            user.icon(),
            user.background(),
            user.followers(),
            user.following(),
            user.createdAt(),
            user.updatedAt(),
            user.about(),
            user.userType(),
            user.notification(),
            user.ban()
        );
    }

    public User toDomain(UserEntity userEntity){
        return new User(
            userEntity.getId(),
            userEntity.getName(),
            userEntity.getUsername(),
            userEntity.getEmail(),
            userEntity.getPassword(),
            userEntity.getIcon(),
            userEntity.getBackground(),
            userEntity.getFollowers(),
            userEntity.getFollowing(),
            userEntity.getCreatedAt(),
            userEntity.getUpdatedAt(),
            userEntity.getAbout(),
            userEntity.getUserType(),
            userEntity.getNotification(),
            userEntity.isBan()
        );
    }
}
