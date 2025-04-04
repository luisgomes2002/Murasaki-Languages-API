package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;

public interface UpdateUserPasswordUsecase {

    User execute(String id, String newPassword);
}
