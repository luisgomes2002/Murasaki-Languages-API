package languages.murasaki.MurasakiLanguages.infra.dtos;

import languages.murasaki.MurasakiLanguages.core.Enums.UserType;
import languages.murasaki.MurasakiLanguages.core.entities.Post;

import java.time.LocalDateTime;
import java.util.List;

public record UserDto(String name, String username, String email, String password, String avatar, String background, String followers, String following,
                      LocalDateTime createdAt, LocalDateTime updatedAt, String about, UserType userType, List<String> notification) {
}
