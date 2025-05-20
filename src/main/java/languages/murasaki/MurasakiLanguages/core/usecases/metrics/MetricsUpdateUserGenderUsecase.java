package languages.murasaki.MurasakiLanguages.core.usecases.metrics;

import languages.murasaki.MurasakiLanguages.core.enums.Gender;

public interface MetricsUpdateUserGenderUsecase {
    void execute(String gender, int delta);
}
