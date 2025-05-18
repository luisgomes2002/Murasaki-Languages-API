package languages.murasaki.MurasakiLanguages.core.entities.lesson;

import java.util.List;

public record UserAnswersLog(String id, String userId, List<UserAnswers> answers) {
}
