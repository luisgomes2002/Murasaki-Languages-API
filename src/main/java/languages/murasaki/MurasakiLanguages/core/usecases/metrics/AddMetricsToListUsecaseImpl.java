package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddMetricsToListUsecaseImpl implements AddMetricsToListUsecase {

    private final MetricsGateway metricsGateway;

    public AddMetricsToListUsecaseImpl(MetricsGateway metricsGateway) {
        this.metricsGateway = metricsGateway;
    }

    @Override
    public void execute(LocalDate date) {
        metricsGateway.addMetricsToList(date);
    }
}
