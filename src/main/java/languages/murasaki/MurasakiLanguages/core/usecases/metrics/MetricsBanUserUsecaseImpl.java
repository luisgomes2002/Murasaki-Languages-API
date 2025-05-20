package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;

public class MetricsBanUserUsecaseImpl implements MetricsBanUserUsecase{

    private final MetricsGateway metricsGateway;

    public MetricsBanUserUsecaseImpl(MetricsGateway metricsGateway) {
        this.metricsGateway = metricsGateway;
    }

    @Override
    public void execute(int delta) {
        metricsGateway.metricsBanUser(delta);
    }
}
