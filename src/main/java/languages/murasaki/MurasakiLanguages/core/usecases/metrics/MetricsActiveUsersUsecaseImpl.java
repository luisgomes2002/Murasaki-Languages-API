package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;

public class MetricsActiveUsersUsecaseImpl implements MetricsActiveUsersUsecase{
    private final MetricsGateway metricsGateway;

    public MetricsActiveUsersUsecaseImpl(MetricsGateway metricsGateway) {
        this.metricsGateway = metricsGateway;
    }

    @Override
    public void execute(int delta) {
        metricsGateway.metricsActiveUsers(delta);
    }
}
