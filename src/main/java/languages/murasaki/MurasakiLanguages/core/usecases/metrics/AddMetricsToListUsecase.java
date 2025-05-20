package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface AddMetricsToListUsecase {
    void execute(LocalDate date);
}
