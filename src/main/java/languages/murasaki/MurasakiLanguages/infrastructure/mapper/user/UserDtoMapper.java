package languages.murasaki.MurasakiLanguages.infrastructure.mapper.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.infrastructure.dtos.user.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public UserDto toDto(User user){
        return new UserDto (
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

    public User toDomain(UserDto userDto){
        return new User (
            userDto.id(),
            userDto.name(),
            userDto.username(),
            userDto.email(),
            userDto.password(),
            userDto.icon(),
            userDto.background(),
            userDto.followersId(),
            userDto.followingId(),
            userDto.createdAt(),
            userDto.updatedAt(),
            userDto.about(),
            userDto.userType(),
            userDto.notificationsId(),
            userDto.postsId(),
            userDto.ban()
        );
    }
}
