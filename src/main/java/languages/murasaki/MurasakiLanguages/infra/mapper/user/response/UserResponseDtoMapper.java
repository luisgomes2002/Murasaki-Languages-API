package languages.murasaki.MurasakiLanguages.infra.mapper.user.response;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.infra.dtos.user.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserResponseDtoMapper {

    public UserResponseDto toDto(User user){
        return new UserResponseDto (
                user.id(),
                user.name(),
                user.gender(),
                user.birth(),
                user.username(),
                user.email(),
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
                user.isEnabled()
        );
    }
}
