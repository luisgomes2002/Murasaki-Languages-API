package languages.murasaki.MurasakiLanguages.infra.exeptions;

public class DuplicateUserException extends RuntimeException{

    public DuplicateUserException(String message){
        super(message);
    }
}
