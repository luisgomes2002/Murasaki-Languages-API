package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "completed_lesson")
public class CompletedLessonEntity {

    private String userId;
    private List<String> completedLesson;

    public CompletedLessonEntity() {
    }

    public CompletedLessonEntity(String userId, List<String> completedLesson) {
        this.userId = userId;
        this.completedLesson = completedLesson;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getCompletedLesson() {
        return completedLesson;
    }

    public void setCompletedLesson(List<String> completedLesson) {
        this.completedLesson = completedLesson;
    }
}
