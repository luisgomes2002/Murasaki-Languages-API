package languages.murasaki.MurasakiLanguages.infrastructure.exceptions;

public class DuplicateUserException extends RuntimeException{

    public DuplicateUserException(String message){
        super(message);
    }
}
