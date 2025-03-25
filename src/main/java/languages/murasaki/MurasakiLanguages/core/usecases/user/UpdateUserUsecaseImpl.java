package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;

public class UpdateUserUsecaseImpl implements UpdateUserUsecase{

    private final UserGateway userGateway;

    public UpdateUserUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(String id, User user) {
       return userGateway.updateUser(id, user);
    }
}
