package languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.WorksheetsGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class DeleteWorksheetsUseCaseImpl implements DeleteWorksheetsUseCase{

    private final WorksheetsGateway worksheetsGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public DeleteWorksheetsUseCaseImpl(WorksheetsGateway worksheetsGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.worksheetsGateway = worksheetsGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void execute(String id) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        worksheetsGateway.deleteWorksheets(id);
    }
}
