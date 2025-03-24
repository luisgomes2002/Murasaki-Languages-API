package languages.murasaki.MurasakiLanguages.infrastructure.exceptions;

public class MissingArgumentsException extends RuntimeException {
    public MissingArgumentsException(String message) {
        super(message);
    }
}
