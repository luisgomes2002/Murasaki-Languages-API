package languages.murasaki.MurasakiLanguages.infra.exceptions;

public class UserBannedException extends RuntimeException {
  public UserBannedException(String message) {
    super(message);
  }
}
