package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.entities.metrics.Metrics;

public interface GetMetricByDateUsecase {
    Metrics execute(String date);
}
