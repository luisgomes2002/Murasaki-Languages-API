package languages.murasaki.MurasakiLanguages.infrastructure.exeptions;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException (String message){
        super(message);
    }
}
