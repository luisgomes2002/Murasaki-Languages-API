package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;

public class RemoveBirthFromListUsecaseImpl implements RemoveBirthFromListUsecase{

    private final MetricsGateway metricsGateway;

    public RemoveBirthFromListUsecaseImpl(MetricsGateway metricsGateway) {
        this.metricsGateway = metricsGateway;
    }

    @Override
    public void execute(String userId) {
        metricsGateway.removeBirthFromList(userId);
    }
}
