package ee.bcs.valiit.tasks.bank.exception;

public class ApplicationException extends RuntimeException{
    public ApplicationException(String message){
        super(message);
    }
}
