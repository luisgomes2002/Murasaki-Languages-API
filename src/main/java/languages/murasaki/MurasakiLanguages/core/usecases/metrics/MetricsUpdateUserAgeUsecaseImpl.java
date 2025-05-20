package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MetricsUpdateUserAgeUsecaseImpl implements MetricsUpdateUserAgeUsecase {
    private final MetricsGateway metricsGateway;

    public MetricsUpdateUserAgeUsecaseImpl(MetricsGateway metricsGateway) {
        this.metricsGateway = metricsGateway;
    }

    @Override
    public void execute(LocalDate age, int delta) {
        metricsGateway.metricsUpdateUserAge(age, delta);
    }
}
