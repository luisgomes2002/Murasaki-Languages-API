package languages.murasaki.MurasakiLanguages.infra.dtos.user;

import languages.murasaki.MurasakiLanguages.core.enums.SubscriptionType;

public record UserInfoDto(String userId, String username, String userType, String email, String subscription) {
}
