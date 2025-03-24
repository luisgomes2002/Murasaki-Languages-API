package languages.murasaki.MurasakiLanguages.infrastructure.exceptions;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException (String message){
        super(message);
    }
}
