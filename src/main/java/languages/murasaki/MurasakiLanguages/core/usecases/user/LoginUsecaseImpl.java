package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.Login;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.infrastructure.exeptions.EmailOrPasswordIncorrectException;

public class LoginUsecaseImpl implements LoginUsecase{

    private final UserGateway userGateway;

    public LoginUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public String execute(Login login) {
        if(!userGateway.userAlreadyCreated(login.email())){
            throw new EmailOrPasswordIncorrectException("Email ou senha incorretos");
        }
        return userGateway.login(login);
    }
}
