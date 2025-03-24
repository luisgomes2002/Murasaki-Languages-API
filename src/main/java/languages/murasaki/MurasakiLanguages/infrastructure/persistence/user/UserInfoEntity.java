package languages.murasaki.MurasakiLanguages.infrastructure.persistence.user;

public class UserInfoEntity {

    private String userId;
    private String username;
    private String userType;
    private String email;

    public UserInfoEntity() {
    }

    public UserInfoEntity(String userId, String username, String userType, String email) {
        this.userId = userId;
        this.username = username;
        this.userType = userType;
        this.email = email;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
