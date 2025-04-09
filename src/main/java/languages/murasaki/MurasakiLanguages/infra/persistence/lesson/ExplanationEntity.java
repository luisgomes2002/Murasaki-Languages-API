package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import org.springframework.data.annotation.Id;

public class ExplanationEntity {

    @Id
    private String id;

    private String phrase;
    private String translation;
    private String explanation;

    public ExplanationEntity() {
    }

    public ExplanationEntity(String id, String phrase, String translation, String explanation) {
        this.id = id;
        this.phrase = phrase;
        this.translation = translation;
        this.explanation = explanation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
