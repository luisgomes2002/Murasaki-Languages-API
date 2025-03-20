package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.user.Login;
import languages.murasaki.MurasakiLanguages.core.entities.user.User;

import java.util.List;

public interface UserGateway {

    User createUser(User user);
    List<User> getUsers();
    User getUserById(String id);
    User updateUser(String id, User user);

    void deleteUser(String id);


    String login(Login login);


    boolean userAlreadyCreated(String email);
    boolean userIdExists(String id);
}
