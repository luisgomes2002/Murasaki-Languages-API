package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;

public class GetUserByEmailUsecaseImpl implements GetUserByEmailUsecase{
    private final UserGateway userGateway;

    public GetUserByEmailUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(String email) {
        return userGateway.getUserByEmail(email);
    }
}
