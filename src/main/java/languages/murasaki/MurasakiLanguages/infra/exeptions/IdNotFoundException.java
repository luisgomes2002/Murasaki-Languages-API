package languages.murasaki.MurasakiLanguages.infra.exeptions;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException (String message){
        super(message);
    }
}
