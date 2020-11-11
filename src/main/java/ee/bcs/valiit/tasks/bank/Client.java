package ee.bcs.valiit.tasks.bank;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    public List<Account> clientAccounts = new ArrayList<>();

    public Client(){

    }
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
