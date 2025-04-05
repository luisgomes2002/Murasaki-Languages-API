package languages.murasaki.MurasakiLanguages.core.usecases.report;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.ReportGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class UpdateReportStatusUsecaseImpl implements  UpdateReportStatusUsecase{

    private final ReportGateway reportGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public UpdateReportStatusUsecaseImpl(ReportGateway reportGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.reportGateway = reportGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public void execute(String id, boolean finished) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        reportGateway.updateReportStatus(id, finished);
    }
}
