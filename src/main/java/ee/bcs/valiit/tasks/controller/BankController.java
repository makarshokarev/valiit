package ee.bcs.valiit.tasks.controller;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("bank")
@RestController
public class BankController {

    Map<String, BigDecimal> map = new HashMap<>();
    Map<String, Client> clients = new HashMap<>();

    // show created accounts
    @GetMapping("account")
    public Map<String, BigDecimal> getAccounts(){
        return map;
    }

//    // createAccount (accountNr)
//    @PostMapping("account/create")
//    public String createAccount(@RequestBody Account account){
//        map.put(account.getAccountNr(), account.getMoney());
//        return "Created new account " + account.getAccountNr();
//    }

    // depositMoney (accountNr, money)
    @PutMapping("account/deposit")
    public String depositMoney(@RequestBody Account account){
        BigDecimal newBalance = account.deposit(map.get(account.getAccountNr()));
        map.put(account.getAccountNr(), newBalance);
        return "Account: " + account.getAccountNr() + ", Balance: " + account.getMoney();
    }

    // withdrawMoney (accountNr, money)
    @PutMapping("account/withdraw")
    public String withdrawMoney(@RequestBody Account account){
        BigDecimal newBalance = account.withdraw(map.get(account.getAccountNr()));
        map.put(account.getAccountNr(), newBalance);
        return "Account: " + account.getAccountNr() + ", Balance: " + account.getMoney();
    }

    // transferMoney (fromAccount, toAccount, money)
    @PutMapping("account/transfer")
    public void transferMoney(@RequestBody AccountBalance transfer){
        BigDecimal newBalance1 = map.get(transfer.getFromAccount()).subtract(transfer.getMoney());
        BigDecimal newBalance2 = map.get(transfer.getToAccount()).add(transfer.getMoney());
        map.put(transfer.getFromAccount(), newBalance1);
        map.put(transfer.getToAccount(), newBalance2);
//        return "Account: " + account.getFromAccount() + " Balance: " + newBalance1 + ", " +
//                "Account: " + account.getToAccount() + " Balance: " + newBalance2;
    }

    // getAccountBalance (accountNr)
    @GetMapping("account/balance")
    public String getBalance(@RequestBody Account account){
        return "Account:" + account.getAccountNr() + ", Balance:" + map.get(account.getAccountNr());
    }
    // Raskem
    // createClient(firstName lastName, ....)

    @PostMapping("client/create")
    public void createClient(@RequestBody Client client){
        Client client1 = new Client(client.getId(), client.getFirstName(), client.getLastName());
        clients.put(client1.getId(), client1);
    }

    @GetMapping("client")
    public Map<String,Client> getClients(){
        return clients;
    }
    // muuta createAccount (clientId, accountNr)
    // createAccount (accountNr)
    @PostMapping("account/create")
    public void createAccount(@RequestBody Account account){
        Account account1 = new Account(account.getId(), account.getAccountNr(), BigDecimal.ZERO);
        Client a = clients.get(account.getId());
        a.account.add(account1);
    }

    // getBalanceHistory(accountNr)
}
