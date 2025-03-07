package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.User;

public interface CreateUserUsecase {

    public User execute(User user);
}
