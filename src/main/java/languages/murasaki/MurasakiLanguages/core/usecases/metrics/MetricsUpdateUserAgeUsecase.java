package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface MetricsUpdateUserAgeUsecase {
    void execute(LocalDate age, String userId);
}
