package languages.murasaki.MurasakiLanguages.infrastructure.exceptions;

public class UserDoesNotHavePermissionException extends RuntimeException {
    public UserDoesNotHavePermissionException(String message) {
        super(message);
    }
}
