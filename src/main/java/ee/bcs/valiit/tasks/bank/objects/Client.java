package ee.bcs.valiit.tasks.bank.objects;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String firstName;
    private String lastName;
    public List<String> clientAccounts = new ArrayList<>();

    public Client() {
    }

    public List<String> getClientAccounts() {
        return clientAccounts;
    }

    public void setClientAccounts(List<String> clientAccounts) {
        this.clientAccounts = clientAccounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
