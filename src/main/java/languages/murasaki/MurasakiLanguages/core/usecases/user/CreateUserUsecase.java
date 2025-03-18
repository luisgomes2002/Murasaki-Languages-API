package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;

public interface CreateUserUsecase {

    public User execute(User user);
}
