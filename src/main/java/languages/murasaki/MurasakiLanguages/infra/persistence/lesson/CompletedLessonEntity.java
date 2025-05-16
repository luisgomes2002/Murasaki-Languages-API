package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "completed_lesson")
public class CompletedLessonEntity {

    @Id
    private String id;

    private String userId;
    private List<String> completedLesson = new ArrayList<>();

    public CompletedLessonEntity() {
    }

    public CompletedLessonEntity(String id, String userId, List<String> completedLesson) {
        this.id = id;
        this.userId = userId;
        this.completedLesson = completedLesson;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
