package languages.murasaki.MurasakiLanguages.core.entities;

import languages.murasaki.MurasakiLanguages.core.enums.UserType;

import java.time.LocalDateTime;
import java.util.List;

public record User(String id, String name, String username, String email, String password, String icon, String background, String followers, String following,
                   LocalDateTime createdAt, LocalDateTime updatedAt, String about, UserType userType, List<String> notification, boolean ban) {

}
