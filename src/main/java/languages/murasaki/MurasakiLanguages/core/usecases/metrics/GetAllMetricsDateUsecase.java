package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.entities.metrics.MetricsDate;

import java.util.List;

public interface GetAllMetricsDateUsecase {
     List<MetricsDate> execute();
}
