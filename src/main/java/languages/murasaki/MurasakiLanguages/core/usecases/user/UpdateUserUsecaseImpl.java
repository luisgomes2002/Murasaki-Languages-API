package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.IdNotFoundException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.MissingArgumentsException;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class UpdateUserUsecaseImpl implements UpdateUserUsecase{

    private final UserGateway userGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public UpdateUserUsecaseImpl(UserGateway userGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.userGateway = userGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public User execute(String id, User user) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!id.equals(userInfo.userId())) throw new UserDoesNotHavePermissionException("Ação bloqueada.");

        if(!userGateway.userIdExists(id)) throw new IdNotFoundException("Usuário não encontrado.");

        if(user.name().isEmpty() || user.email().isEmpty() || user.username().isEmpty()) throw new MissingArgumentsException("Campos não podem estar vazios.");

        return userGateway.updateUser(id, user);
    }
}
