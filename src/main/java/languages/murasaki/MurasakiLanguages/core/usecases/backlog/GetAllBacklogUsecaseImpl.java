package languages.murasaki.MurasakiLanguages.core.usecases.backlog;

import languages.murasaki.MurasakiLanguages.core.entities.backlog.Backlog;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.BacklogGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

import java.util.List;

public class GetAllBacklogUsecaseImpl implements GetAllBacklogUsecase{

    private final BacklogGateway backlogGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetAllBacklogUsecaseImpl(BacklogGateway backlogGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.backlogGateway = backlogGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public List<Backlog> execute() {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return backlogGateway.getAllBacklog();
    }
}
