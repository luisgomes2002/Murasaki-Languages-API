package languages.murasaki.MurasakiLanguages.core.entities.user;

import java.io.Serializable;

public record UserInfo(String userId, String username, String userType, String email) {
}
