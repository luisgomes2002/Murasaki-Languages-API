package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;

public class MetricsByLanguageUsecaseImpl implements MetricsByLanguageUsecase{

    private final MetricsGateway metricsGateway;

    public MetricsByLanguageUsecaseImpl(MetricsGateway metricsGateway) {
        this.metricsGateway = metricsGateway;
    }

    @Override
    public void execute(String language, int delta) {
        metricsGateway.metricsByLanguage(language, delta);
    }
}
