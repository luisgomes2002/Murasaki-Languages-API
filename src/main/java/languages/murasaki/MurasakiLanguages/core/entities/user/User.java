package languages.murasaki.MurasakiLanguages.core.entities.user;

import languages.murasaki.MurasakiLanguages.core.enums.Gender;
import languages.murasaki.MurasakiLanguages.core.enums.UserType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record User(String id,
                   String name,
                   Gender gender,
                   LocalDate birth,
                   String username,
                   String email,
                   String password,
                   String icon,
                   String background,
                   List<String> followersId,
                   List<String> followingId,
                   LocalDateTime createdAt,
                   LocalDateTime updatedAt,
                   String about,
                   UserType userType,
                   List<String> notificationsId,
                   List<String> postsId,
                   boolean isEnabled,
                   boolean isBanned
) implements Serializable {
}
