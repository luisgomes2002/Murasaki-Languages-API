package languages.murasaki.MurasakiLanguages.core.entities.lesson;

import java.util.List;

public record CompletedLesson(String id, String userId, List<String> completedLessons) {
}
