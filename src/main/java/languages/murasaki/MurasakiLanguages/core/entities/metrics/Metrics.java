package languages.murasaki.MurasakiLanguages.core.entities.metrics;

import languages.murasaki.MurasakiLanguages.core.enums.Gender;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;

import java.time.LocalDateTime;
import java.util.Map;

public record Metrics(
        String id,
        LocalDateTime date,
        int totalUsers,
        int activeUsers,
        int bannedUsers,
        int deletedUsers,
        Map<String, Integer> userAgeDistribution,
        Map<LanguageType, Integer> topLanguages,
        Map<Gender, Integer> topGender
) { }
