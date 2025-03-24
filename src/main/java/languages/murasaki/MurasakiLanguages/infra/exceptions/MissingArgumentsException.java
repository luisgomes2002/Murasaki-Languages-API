package languages.murasaki.MurasakiLanguages.infra.exceptions;

public class MissingArgumentsException extends RuntimeException {
    public MissingArgumentsException(String message) {
        super(message);
    }
}
