package ee.bcs.valiit.tasks.bank.Exception;

public class ApplicationException extends RuntimeException{
    public ApplicationException(String message){
        super(message);
    }
}
