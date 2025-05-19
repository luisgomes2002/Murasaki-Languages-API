package languages.murasaki.MurasakiLanguages.core.usecases.report;

import languages.murasaki.MurasakiLanguages.core.entities.report.Report;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.ReportGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

import java.util.List;

public class GetAllReportsUsecaseImpl implements GetAllReportsUsecase{

    private final ReportGateway reportGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetAllReportsUsecaseImpl(ReportGateway reportGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.reportGateway = reportGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public List<Report> execute(int page, int size) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return reportGateway.getAllReports(page, size);
    }
}
