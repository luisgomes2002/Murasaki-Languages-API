package languages.murasaki.MurasakiLanguages.core.usecases.lesson.worksheets;

import languages.murasaki.MurasakiLanguages.core.entities.lesson.Worksheets;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.WorksheetsGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class UpdateWorksheetsUseCaseImpl implements UpdateWorksheetsUseCase{

    private final WorksheetsGateway worksheetsGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public UpdateWorksheetsUseCaseImpl(WorksheetsGateway worksheetsGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.worksheetsGateway = worksheetsGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public Worksheets execute(String id, Worksheets worksheets) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return worksheetsGateway.updateWorksheet(id, worksheets);
    }
}
