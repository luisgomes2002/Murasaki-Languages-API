package languages.murasaki.MurasakiLanguages.infra.exceptions;

public class EmailOrPasswordIncorrectException extends RuntimeException{

    public EmailOrPasswordIncorrectException(String message){
        super(message);
    }
}
