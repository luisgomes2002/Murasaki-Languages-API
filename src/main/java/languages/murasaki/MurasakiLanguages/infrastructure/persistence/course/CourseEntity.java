package languages.murasaki.MurasakiLanguages.infrastructure.persistence.course;

import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "Course")
public class CourseEntity {

    @Id
    private String id;

    private String title;
    private String text;
    private List<String> links;
    private String username;
    private LanguageType languageType;
    private JapaneseLevels japaneseLevels;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public CourseEntity() {
    }

    public CourseEntity(String id, String title, String text, List<String> links, String username, LanguageType languageType, JapaneseLevels japaneseLevels, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.links = links;
        this.username = username;
        this.languageType = languageType;
        this.japaneseLevels = japaneseLevels;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LanguageType getLanguageType() {
        return languageType;
    }

    public void setLanguageType(LanguageType languageType) {
        this.languageType = languageType;
    }

    public JapaneseLevels getJapaneseLevels() {
        return japaneseLevels;
    }

    public void setJapaneseLevels(JapaneseLevels japaneseLevels) {
        this.japaneseLevels = japaneseLevels;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
