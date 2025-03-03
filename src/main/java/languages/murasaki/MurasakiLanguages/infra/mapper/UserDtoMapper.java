package languages.murasaki.MurasakiLanguages.infra.mapper;

import languages.murasaki.MurasakiLanguages.core.entities.User;
import languages.murasaki.MurasakiLanguages.infra.dtos.UserDto;

public class UserDtoMapper {

    public UserDto toDto(User user){
        return new UserDto (
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

    public User toDomain(UserDto userDto){
        return new User (
            userDto.name(),
            userDto.username(),
            userDto.email(),
            userDto.password(),
            userDto.avatar(),
            userDto.background(),
            userDto.followers(),
            userDto.following(),
            userDto.createdAt(),
            userDto.updatedAt(),
            userDto.about(),
            userDto.userType(),
            userDto.notification()
        );
    }
}
