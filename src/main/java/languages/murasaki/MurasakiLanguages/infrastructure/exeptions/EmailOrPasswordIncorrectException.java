package languages.murasaki.MurasakiLanguages.infrastructure.exeptions;

public class EmailOrPasswordIncorrectException extends RuntimeException{

    public EmailOrPasswordIncorrectException(String message){
        super(message);
    }
}
