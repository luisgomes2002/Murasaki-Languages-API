package languages.murasaki.MurasakiLanguages.infra.exceptions;

public class DuplicateUserException extends RuntimeException{

    public DuplicateUserException(String message){
        super(message);
    }
}
