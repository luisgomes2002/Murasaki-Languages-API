package languages.murasaki.MurasakiLanguages.infra.dtos.user;

import languages.murasaki.MurasakiLanguages.core.enums.UserType;

import java.time.LocalDateTime;
import java.util.List;

public record UserDto(String id, String name, String username, String email, String password, String icon, String background,
                   List<String> followersId, List<String> followingId, LocalDateTime createdAt, LocalDateTime updatedAt,
                   String about, UserType userType, List<String> notificationsId, List<String> postsId, boolean isEnabled) {
}