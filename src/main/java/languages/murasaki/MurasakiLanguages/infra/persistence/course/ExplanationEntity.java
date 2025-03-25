package languages.murasaki.MurasakiLanguages.infra.persistence.course;

import org.springframework.data.annotation.Id;

public class ExplanationEntity {

    private String phrase;
    private String translation;
    private String explanation;

    public ExplanationEntity() {
    }

    public ExplanationEntity(String phrase, String translation, String explanation) {
        this.phrase = phrase;
        this.translation = translation;
        this.explanation = explanation;
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
