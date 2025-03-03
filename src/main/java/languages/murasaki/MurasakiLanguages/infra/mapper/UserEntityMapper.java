package languages.murasaki.MurasakiLanguages.infra.mapper;

import languages.murasaki.MurasakiLanguages.core.entities.User;
import languages.murasaki.MurasakiLanguages.infra.persistence.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user){
        return new UserEntity(
            user.name(),
            user.username(),
            user.email(),
            user.password(),
            user.avatar(),
            user.background(),
            user.followers(),
            user.following(),
            user.createdAt(),
            user.updatedAt(),
            user.about(),
            user.userType(),
            user.notification()
        );
    }

    public User toDomain(UserEntity userEntity){
        return new User(
            userEntity.getName(),
            userEntity.getUsername(),
            userEntity.getEmail(),
            userEntity.getPassword(),
            userEntity.getAvatar(),
            userEntity.getBackground(),
            userEntity.getFollowers(),
            userEntity.getFollowing(),
            userEntity.getCreatedAt(),
            userEntity.getUpdatedAt(),
            userEntity.getAbout(),
            userEntity.getUserType(),
            userEntity.getNotification()
        );
    }
}
