package languages.murasaki.MurasakiLanguages.infra.persistence.notification;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Notifications")
public class NotificationEntity {

    @Id
    private String id;

    private String userId;
    private String username;
    private String text;

    public NotificationEntity() {
    }

    public NotificationEntity(String id, String userId, String username, String text) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.text = text;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
