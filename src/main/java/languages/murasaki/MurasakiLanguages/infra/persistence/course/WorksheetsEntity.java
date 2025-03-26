package languages.murasaki.MurasakiLanguages.infra.persistence.course;

import java.util.List;

public class WorksheetsEntity {

    private String courseId;
    private String question;
    private List<String> options;
    private String answer;

    public WorksheetsEntity() {
    }

    public WorksheetsEntity(String courseId, String question, List<String> options, String answer) {
        this.courseId = courseId;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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
