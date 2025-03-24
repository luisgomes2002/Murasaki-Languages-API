package languages.murasaki.MurasakiLanguages.infra.exceptions;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException (String message){
        super(message);
    }
}
