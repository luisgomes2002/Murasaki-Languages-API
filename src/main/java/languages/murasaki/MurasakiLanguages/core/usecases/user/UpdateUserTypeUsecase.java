package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.enums.UserType;

public interface UpdateUserTypeUsecase {

    void execute(String id , UserType type);
}
