package languages.murasaki.MurasakiLanguages.core.entities.user;

import languages.murasaki.MurasakiLanguages.core.enums.SubscriptionType;

import java.io.Serializable;

public record UserInfo(String userId, String username, String userType, String email, String subscription) {
}
