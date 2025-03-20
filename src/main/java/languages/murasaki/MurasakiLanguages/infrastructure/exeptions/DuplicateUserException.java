package languages.murasaki.MurasakiLanguages.infrastructure.exeptions;

public class DuplicateUserException extends RuntimeException{

    public DuplicateUserException(String message){
        super(message);
    }
}
