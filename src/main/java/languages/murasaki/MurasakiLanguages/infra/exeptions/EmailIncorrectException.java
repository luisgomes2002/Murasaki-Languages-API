package languages.murasaki.MurasakiLanguages.infra.exeptions;

public class EmailIncorrectException extends RuntimeException{

    public EmailIncorrectException(String message){
        super(message);
    }
}
