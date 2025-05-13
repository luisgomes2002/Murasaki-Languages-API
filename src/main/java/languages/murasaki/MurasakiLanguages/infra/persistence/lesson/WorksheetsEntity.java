package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "work-sheets")
public class WorksheetsEntity {

    @Id
    private String id;

    private String question;
    private List<String> options;
    private String answer;
    private String explanation;

    public WorksheetsEntity() {
    }

    public WorksheetsEntity(String id, String question, List<String> options, String answer, String explanation) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.explanation = explanation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
