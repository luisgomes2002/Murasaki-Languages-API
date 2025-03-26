package languages.murasaki.MurasakiLanguages.infra.persistence.course;

import languages.murasaki.MurasakiLanguages.core.entities.course.Explanation;
import languages.murasaki.MurasakiLanguages.core.entities.course.Worksheets;
import languages.murasaki.MurasakiLanguages.core.enums.JapaneseLevels;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;
import languages.murasaki.MurasakiLanguages.infra.dtos.course.ExplanationDto;
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
    private List<Explanation> explanations;
    private List<Worksheets> worksheets;
    private List<String> links;
    private String username;
    private LanguageType languageType;
    private JapaneseLevels japaneseLevels;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
    private boolean published;

    public CourseEntity() {
    }

    public CourseEntity(String id, String title, String text, List<Explanation> explanations, List<Worksheets> worksheets, List<String> links, String username, LanguageType languageType, JapaneseLevels japaneseLevels, LocalDateTime createAt, LocalDateTime updatedAt, boolean published) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.explanations = explanations;
        this.worksheets = worksheets;
        this.links = links;
        this.username = username;
        this.languageType = languageType;
        this.japaneseLevels = japaneseLevels;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
        this.published = published;
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

    public List<Explanation> getExplanations() {
        return explanations;
    }

    public void setExplanations(List<Explanation> explanations) {
        this.explanations = explanations;
    }

    public List<Worksheets> getWorksheets() {
        return worksheets;
    }

    public void setWorksheets(List<Worksheets> worksheets) {
        this.worksheets = worksheets;
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

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
