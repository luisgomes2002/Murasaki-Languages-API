package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.pagination.Pagination;
import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.entities.user.UserResponse;

import java.util.List;

public interface GetAllUsersUseCase {

    public Pagination<User> execute(int page, int size);
}
