package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.entities.metrics.Metrics;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserInfo;
import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;
import languages.murasaki.MurasakiLanguages.core.usecases.security.AuthenticatedUsecase;
import languages.murasaki.MurasakiLanguages.infra.exceptions.UserDoesNotHavePermissionException;

public class GetMetricByDateUsecaseImpl implements GetMetricByDateUsecase{

    private final MetricsGateway metricsGateway;
    private final AuthenticatedUsecase authenticatedUsecase;

    public GetMetricByDateUsecaseImpl(MetricsGateway metricsGateway, AuthenticatedUsecase authenticatedUsecase) {
        this.metricsGateway = metricsGateway;
        this.authenticatedUsecase = authenticatedUsecase;
    }

    @Override
    public Metrics execute(String date) {
        UserInfo userInfo = authenticatedUsecase.getAuthenticatedUser();

        if(!"ADMIN".equals(userInfo.userType()) && !"MOD".equals(userInfo.userType())) throw new UserDoesNotHavePermissionException("Ação bloqueada");

        return metricsGateway.getMetricByDate(date);
    }
}
