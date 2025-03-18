package languages.murasaki.MurasakiLanguages.infra.mapper.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.infra.persistence.User.UserEntity;
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
            user.followersId(),
            user.followingId(),
            user.createdAt(),
            user.updatedAt(),
            user.about(),
            user.userType(),
            user.notificationsId(),
            user.postsId(),
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
            userEntity.getFollowersId(),
            userEntity.getFollowingId(),
            userEntity.getCreatedAt(),
            userEntity.getUpdatedAt(),
            userEntity.getAbout(),
            userEntity.getUserType(),
            userEntity.getNotificationsId(),
            userEntity.getPostsId(),
            userEntity.isBan()
        );
    }
}
