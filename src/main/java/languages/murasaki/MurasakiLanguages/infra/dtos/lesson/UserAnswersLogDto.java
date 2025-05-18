package languages.murasaki.MurasakiLanguages.infra.dtos.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswers;

import java.util.List;

public record UserAnswersLogDto(String id, String userId, List<UserAnswers> answers) {
}
