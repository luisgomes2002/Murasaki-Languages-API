package languages.murasaki.MurasakiLanguages.core.entities.lesson;

import java.io.Serializable;
import java.util.List;

public record CompletedLesson(String id, String userId, List<String> completedLessons) implements Serializable {
}
