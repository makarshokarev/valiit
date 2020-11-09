package ee.bcs.valiit.tasks.controller;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    public List<Account> account = new ArrayList<>();

    public Client(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public List<Account> getAccount() {
//        return account;
//    }
//
//    public void setAccount(List<Account> account) {
//        this.account = account;
//    }

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

}
