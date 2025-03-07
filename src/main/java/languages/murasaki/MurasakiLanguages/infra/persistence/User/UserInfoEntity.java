package languages.murasaki.MurasakiLanguages.infra.persistence.User;

import org.springframework.data.annotation.Id;

public class UserInfoEntity {

    @Id
    private String id;

    private String userId;
    private String icon;
    private String username;

    public UserInfoEntity(String id, String userId, String icon, String username) {
        this.id = id;
        this.userId = userId;
        this.icon = icon;
        this.username = username;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
