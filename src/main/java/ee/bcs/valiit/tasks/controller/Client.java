package ee.bcs.valiit.tasks.controller;

import java.util.List;

public class Client {
    private String firstName;
    private String lastName;
    private List<Account> account;

    public Client(String firstName, String lastName, List<Account> account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
