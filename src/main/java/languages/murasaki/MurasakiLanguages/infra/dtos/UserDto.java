package languages.murasaki.MurasakiLanguages.infra.dtos;

import languages.murasaki.MurasakiLanguages.core.enums.UserType;

import java.time.LocalDateTime;
import java.util.List;

public record UserDto(String id, String name, String username, String email, String password, String icon, String background, String followers, String following,
                      LocalDateTime createdAt, LocalDateTime updatedAt, String about, UserType userType, List<String> notification, boolean ban) {
}
