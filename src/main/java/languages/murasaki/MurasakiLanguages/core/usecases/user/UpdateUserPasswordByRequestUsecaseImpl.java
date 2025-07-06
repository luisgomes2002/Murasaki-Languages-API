package languages.murasaki.MurasakiLanguages.core.usecases.user;

import languages.murasaki.MurasakiLanguages.core.entities.user.User;
import languages.murasaki.MurasakiLanguages.core.gateway.UserGateway;

public class UpdateUserPasswordByRequestUsecaseImpl implements UpdateUserPasswordByRequestUsecase{

  private final UserGateway userGateway;

  public UpdateUserPasswordByRequestUsecaseImpl(UserGateway userGateway) {
    this.userGateway = userGateway;
  }

  @Override
  public User execute(String id, String newPassword) {
    return userGateway.updateUserPasswordByRequest(id, newPassword);
  }
}
