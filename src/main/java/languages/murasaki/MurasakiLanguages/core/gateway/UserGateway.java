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

    UserType updateUserType(String type);

    void deleteUser(String id);

    String login(Login login);

    boolean userAlreadyCreated(String email);
    boolean userIdExists(String id);
    boolean isEnable();
}
