package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.infrastructure.exeptions.DuplicateUserException;

public class CreateUserUsecaseImpl implements CreateUserUsecase{

    private final UserGateway userGateway;

    public CreateUserUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        if(userGateway.userAlreadyCreated(user.email())){
            throw new DuplicateUserException("Usuário com email: " + user.email() + " já existe.");
        }
        return userGateway.createUser(user);
    }
}
