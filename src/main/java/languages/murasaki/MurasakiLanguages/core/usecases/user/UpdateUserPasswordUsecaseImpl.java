package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.IdNotFoundException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class UpdateUserPasswordUsecaseImpl implements  UpdateUserPasswordUsecase{

    private final UserGateway userGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public UpdateUserPasswordUsecaseImpl(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.userGateway = userGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public User execute(String id, String newPassword) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!id.equals(userInfo.userId())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(!userGateway.userIdExists(id)) throw new IdNotFoundException("Usuário não encontrado");

        if(newPassword.isEmpty()) throw new MissingArgumentsException("Digite uma senha válida");

        return userGateway.updateUserPassword(id, newPassword);
    }
}
