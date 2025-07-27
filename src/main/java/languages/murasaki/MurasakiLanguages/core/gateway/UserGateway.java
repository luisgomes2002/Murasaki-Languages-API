package languages.murasaki.MurasakiLanguages.core.gateway;

import languages.murasaki.MurasakiLanguages.core.entities.pagination.Pagination;
import languages.murasaki.MurasakiLanguages.core.entities.payment.CheckoutResponse;
import languages.murasaki.MurasakiLanguages.core.entities.user.Login;
import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserResponse;
import languages.murasaki.MurasakiLanguages.core.enums.UserType;

import java.util.List;

public interface UserGateway {

    User createUser(User user);
    Pagination<User> getAllUsers(int page, int size);
    User getUserById(String id);
    User updateUser(String id, User user);
    User updateUserPassword(String id, String newPassword);
    User updateUserPasswordByRequest(String id, String newPassword);
    User getUserByEmail(String email);

    void deleteUser(String id);
    void updateUserType(String id, UserType type);
    void isEnable(String id, boolean isEnable);
    void banUser(String userId, boolean ban);
    void SubscriptionDeleted(String email);

    String login(Login login);
    CheckoutResponse checkoutCompleted(String email, String productName, String userName);

    boolean userAlreadyCreated(String email);
    boolean userUsernameAlreadyCreated(String username);
    boolean userIdExists(String id);
    boolean userIsBanned(String email);
    boolean userIsEnabled(String email);
}
