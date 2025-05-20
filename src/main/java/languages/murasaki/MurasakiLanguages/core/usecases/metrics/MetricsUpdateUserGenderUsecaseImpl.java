package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.enums.Gender;
import languages.murasaki.MurasakiLanguages.core.gateway.MetricsGateway;

public class MetricsUpdateUserGenderUsecaseImpl implements MetricsUpdateUserGenderUsecase {

    private final MetricsGateway metricsGateway;

    public MetricsUpdateUserGenderUsecaseImpl(MetricsGateway metricsGateway) {
        this.metricsGateway = metricsGateway;
    }

    @Override
    public void execute(String gender, int delta) {
        metricsGateway.metricsUpdateUserGender(gender, delta);
    }
}
