package languages.murasaki.MurasakiLanguages.core.entities.lesson;

import java.time.LocalDateTime;

public record UserAnswers(String questionId, String answer, LocalDateTime answeredAt) {
}
