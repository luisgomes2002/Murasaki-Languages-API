package languages.murasaki.MurasakiLanguages.infra.persistence.user;


public class UserInfoEntity {

    private String userId;
    private String name;
    private String userType;
    private String email;
    private String subscription;

    public UserInfoEntity() {
    }

    public UserInfoEntity(String userId, String name, String userType, String email, String subscription) {
        this.userId = userId;
        this.name = name;
        this.userType = userType;
        this.email = email;
        this.subscription = subscription;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }
}
