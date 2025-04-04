package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.IdNotFoundException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class DeleteUserUsecaseImpl implements DeleteUserUsecase{

    private final UserGateway userGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public DeleteUserUsecaseImpl(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.userGateway = userGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void execute(String id) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!id.equals(userInfo.userId())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        if(!userGateway.userIdExists(id)) throw new IdNotFoundException("Usuário não encontrado");

        userGateway.deleteUser(id);
    }
}
