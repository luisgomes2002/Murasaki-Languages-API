package languages.murasaki.MurasakiLanguages.infra.persistence.lesson;

import languages.murasaki.MurasakiLanguages.core.enums.LanguagesLevels;
import languages.murasaki.MurasakiLanguages.core.enums.LanguageType;
import languages.murasaki.MurasakiLanguages.core.enums.Visibility;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "lessons")
public class LessonEntity {

    @Id
    private String id;

    private String title;
    private String text;
    private List<String> explanations =  new ArrayList<>();
    private List<String> worksheets =  new ArrayList<>();
    private List<String> links;
    private String name;
    private LanguageType languageType;
    private LanguagesLevels languagesLevels;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
    private boolean published;
    private Visibility visibility;
    private String ankiLink;
    private String thumbLink;

    public LessonEntity() {
    }

    public LessonEntity(String id, String title, String text, List<String> explanations, List<String> worksheets, List<String> links, String name, LanguageType languageType, LanguagesLevels languagesLevels, LocalDateTime createAt, LocalDateTime updatedAt, boolean published, Visibility visibility, String ankiLink, String thumbLink) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.explanations = explanations;
        this.worksheets = worksheets;
        this.links = links;
        this.name = name;
        this.languageType = languageType;
        this.languagesLevels = languagesLevels;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
        this.published = published;
        this.visibility = visibility;
        this.ankiLink = ankiLink;
        this.thumbLink = thumbLink;
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

    public List<String> getExplanations() {
        return explanations;
    }

    public void setExplanations(List<String> explanations) {
        this.explanations = explanations;
    }

    public List<String> getWorksheets() {
        return worksheets;
    }

    public void setWorksheets(List<String> worksheets) {
        this.worksheets = worksheets;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LanguageType getLanguageType() {
        return languageType;
    }

    public void setLanguageType(LanguageType languageType) {
        this.languageType = languageType;
    }

    public LanguagesLevels getJapaneseLevels() {
        return languagesLevels;
    }

    public void setJapaneseLevels(LanguagesLevels languagesLevels) {
        this.languagesLevels = languagesLevels;
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

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public String getAnkiLink() {
        return ankiLink;
    }

    public void setAnkiLink(String ankiLink) {
        this.ankiLink = ankiLink;
    }

    public String getThumbLink() {
        return thumbLink;
    }

    public void setThumbLink(String thumbLink) {
        this.thumbLink = thumbLink;
    }
}
