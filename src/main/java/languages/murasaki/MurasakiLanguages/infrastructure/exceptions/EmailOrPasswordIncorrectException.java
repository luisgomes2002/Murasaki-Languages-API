package languages.murasaki.MurasakiLanguages.infrastructure.exceptions;

public class EmailOrPasswordIncorrectException extends RuntimeException{

    public EmailOrPasswordIncorrectException(String message){
        super(message);
    }
}
