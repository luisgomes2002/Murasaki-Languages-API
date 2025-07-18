package languages.murasaki.MurasakiLanguages.infra.mapper.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.infra.dtos.user.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public UserDto toDto(User user){
        return new UserDto (
            user.id(),
            user.name(),
            user.gender(),
            user.birth(),
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
            user.isEnabled(),
            user.isBanned(),
            user.subscription()
        );
    }

    public User toDomain(UserDto userDto){
        return new User (
            userDto.id(),
            userDto.name(),
            userDto.gender(),
            userDto.birth(),
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
            userDto.isEnabled(),
            userDto.isBanned(),
            userDto.subscription()
        );
    }
}
