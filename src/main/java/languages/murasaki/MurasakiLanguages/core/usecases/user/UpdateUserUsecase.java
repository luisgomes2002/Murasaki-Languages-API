package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;

public interface UpdateUserUsecase {

    public User execute(String id, User user);
}
