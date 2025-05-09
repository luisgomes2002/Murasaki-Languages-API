package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.Login;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.infra.exceptions.EmailOrPasswordIncorrectException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserBannedException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserNotEnabledException;

public class LoginUsecaseImpl implements LoginUsecase{

    private final UserGateway userGateway;

    public LoginUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public String execute(Login login) {
        if(!userGateway.userAlreadyCreated(login.email())) throw new EmailOrPasswordIncorrectException("Email ou senha incorretos");

        if(userGateway.userIsBanned(login.email())) throw new UserBannedException("Usuário não tem permissão para fazer essa ação!");

        if(!userGateway.userIsEnabled(login.email())) throw new UserNotEnabledException("Usuário não tem permissão para fazer essa ação!");

        return userGateway.login(login);
    }
}
