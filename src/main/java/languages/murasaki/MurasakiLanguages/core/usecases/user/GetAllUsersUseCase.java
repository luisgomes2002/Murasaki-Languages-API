package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;

import java.util.List;

public interface GetAllUsersUseCase {

    public List<User> execute();
}
