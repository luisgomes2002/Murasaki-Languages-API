package languages.murasaki.MurasakiLanguages.infra.dtos.lesson;

import java.util.List;

public record CompletedLessonDto(String userId, List<String> completedLessons){
}
