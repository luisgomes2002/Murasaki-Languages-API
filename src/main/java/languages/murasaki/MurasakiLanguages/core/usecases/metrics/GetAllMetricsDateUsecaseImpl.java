package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.entities.metrics.MetricsDate;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

import java.util.List;

public class GetAllMetricsDateUsecaseImpl implements GetAllMetricsDateUsecase {

    private final MetricsGateway metricsGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetAllMetricsDateUsecaseImpl(MetricsGateway metricsGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.metricsGateway = metricsGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public List<MetricsDate> execute() {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return metricsGateway.getAllMetricsDate();
    }
}
