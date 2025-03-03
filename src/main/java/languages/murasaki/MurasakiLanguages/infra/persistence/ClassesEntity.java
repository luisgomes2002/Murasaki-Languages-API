package languages.murasaki.MurasakiLanguages.infra.persistence;

import languages.murasaki.MurasakiLanguages.core.Enums.LanguageType;

import java.time.LocalDateTime;
import java.util.List;

public class ClassesEntity {

    private String title;
    private String text;
    private List<String> links;
    private String username;
    private LanguageType languageType;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public ClassesEntity() {
    }

    public ClassesEntity(String title, String text, List<String> links, String username, LanguageType languageType, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.title = title;
        this.text = text;
        this.links = links;
        this.username = username;
        this.languageType = languageType;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
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
