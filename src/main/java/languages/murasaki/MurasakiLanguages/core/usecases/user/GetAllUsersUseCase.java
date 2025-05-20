package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.UserResponse;

import java.util.List;

public interface GetAllUsersUseCase {

    public List<UserResponse> execute(int page, int size);
}
