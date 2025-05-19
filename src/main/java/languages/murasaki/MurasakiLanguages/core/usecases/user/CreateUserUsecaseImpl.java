package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.infra.exceptions.DuplicateUserException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;

public class CreateUserUsecaseImpl implements CreateUserUsecase{

    private final UserGateway userGateway;

    public CreateUserUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        if(userGateway.userAlreadyCreated(user.email())) throw new DuplicateUserException("Usuário com email: " + user.email() + " já existe.");

        if(user.name() == null || user.username() == null || user.email() == null || user.password() == null) throw new MissingArgumentsException("Campos faltando");

        if(userGateway.userUsernameAlreadyCreated(user.username())) throw new DuplicateUserException("Username já existe!");

        return userGateway.createUser(user);
    }
}
