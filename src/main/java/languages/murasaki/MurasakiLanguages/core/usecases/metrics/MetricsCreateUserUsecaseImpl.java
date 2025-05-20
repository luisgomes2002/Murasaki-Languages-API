package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;

public class MetricsCreateUserUsecaseImpl implements MetricsCreateUserUsecase {

    private final MetricsGateway metricsGateway;

    public MetricsCreateUserUsecaseImpl(MetricsGateway metricsGateway) {
        this.metricsGateway = metricsGateway;
    }

    @Override
    public void execute() {
        metricsGateway.metricsCreateUser();
    }
}
