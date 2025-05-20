package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;

public class MetricsDeletedUserUsecaseImpl implements MetricsDeletedUserUsecase {

    private final MetricsGateway metricsGateway;

    public MetricsDeletedUserUsecaseImpl(MetricsGateway metricsGateway) {
        this.metricsGateway = metricsGateway;
    }

    @Override
    public void execute() {
        metricsGateway.metricsDeletedUser();
    }
}
