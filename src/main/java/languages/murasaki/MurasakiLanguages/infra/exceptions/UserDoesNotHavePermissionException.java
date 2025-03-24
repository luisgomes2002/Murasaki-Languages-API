package languages.murasaki.MurasakiLanguages.infra.exceptions;

public class UserDoesNotHavePermissionException extends RuntimeException {
    public UserDoesNotHavePermissionException(String message) {
        super(message);
    }
}
