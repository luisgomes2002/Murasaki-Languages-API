package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.user.Login;
import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.enums.UserType;

import java.util.List;

public interface UserGateway {

    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(String id);
    User updateUser(String id, User user);
    User updateUserPassword(String id, String newPassword);

    void deleteUser(String id);
    void updateUserType(String id, UserType type);
    void isEnable(String id, boolean isEnable);

    String login(Login login);

    boolean userAlreadyCreated(String email);
    boolean userIdExists(String id);
    boolean userIsBanned(String email);
    boolean userIsEnabled(String email);
}
