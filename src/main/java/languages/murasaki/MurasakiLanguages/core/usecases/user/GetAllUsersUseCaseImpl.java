package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;

import java.util.List;

public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase{

    private final UserGateway userGateway;

    public GetAllUsersUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<User> execute() {
       return userGateway.getAllUsers();
    }
}
