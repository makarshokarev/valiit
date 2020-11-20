package ee.bcs.valiit.tasks.bank.objects;

public class CreateAccount {
    private int clientId;
    private String accountNr;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }
}
