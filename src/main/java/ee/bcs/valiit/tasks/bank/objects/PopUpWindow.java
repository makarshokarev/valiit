package ee.bcs.valiit.tasks.bank.objects;

public class PopUpWindow {
    private String message;

    public PopUpWindow(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
