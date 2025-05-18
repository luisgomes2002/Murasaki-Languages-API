package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.UserAnswers;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user_answers")
public class UserAnswersLogEntity {

    @Id
    private String id;

    private String userId;
    private List<UserAnswers> answers = new ArrayList<>();

    public UserAnswersLogEntity() {
    }

    public UserAnswersLogEntity(String id, String userId, List<UserAnswers> answers) {
        this.id = id;
        this.userId = userId;
        this.answers = answers;
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

    public List<UserAnswers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<UserAnswers> answers) {
        this.answers = answers;
    }
}
