package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import java.util.List;

public class WorksheetsEntity {

    private String lessonId;
    private String question;
    private List<String> options;
    private String answer;

    public WorksheetsEntity() {
    }

    public WorksheetsEntity(String lessonId, String question, List<String> options, String answer) {
        this.lessonId = lessonId;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
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
}
