package ee.bcs.valiit.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank")
@RestController
public class BankController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    Map<String, Account> map = new HashMap<>();
    Map<String, Client> clients = new HashMap<>();

    // show created accounts
    @GetMapping("account")
    public Map<String, Account> getAccounts() {
        return map;
    }

    // depositMoney (accountNr, money)
    @PutMapping("account/deposit")
    public String depositMoney(@RequestBody Account account) {
        Account mapAccount = map.get(account.getAccountNr());
        BigDecimal newBalance = mapAccount.getMoney().add(account.getMoney());
        mapAccount.setMoney(newBalance);
        return "Account: " + account.getAccountNr() + ", Balance: " + newBalance;
    }

    // withdrawMoney (accountNr, money)
    @PutMapping("account/withdraw")
    public String withdrawMoney(@RequestBody Account account) {
        Account mapAccount = map.get(account.getAccountNr());
        BigDecimal newBalance = mapAccount.getMoney().subtract(account.getMoney());
        mapAccount.setMoney(newBalance);
        return "Account: " + account.getAccountNr() + ", Balance: " + newBalance;
    }

    // transferMoney (fromAccount, toAccount, money)
    @PutMapping("account/transfer")
    public void transferMoney(@RequestBody AccountBalance transfer) {
        Account fromAccount = map.get(transfer.getFromAccount());
        Account toAccount = map.get(transfer.getToAccount());
        BigDecimal newBalance1 = fromAccount.getMoney().subtract(transfer.getMoney());
        BigDecimal newBalance2 = toAccount.getMoney().add(transfer.getMoney());
        fromAccount.setMoney(newBalance1);
        toAccount.setMoney(newBalance2);
    }

    // getAccountBalance (accountNr)
    @GetMapping("account/balance")
    public String getBalance(@RequestBody Account account) {
        Account mapAccount = map.get(account.getAccountNr());
        BigDecimal balance = mapAccount.getMoney();
        return "Account:" + account.getAccountNr() + ", Balance:" + balance;
    }
    // Raskem
    // createClient(firstName lastName, ....)

    @PostMapping("client/create")
    public void createClient(@RequestBody Client client) {
        Client client1 = new Client(client.getId(), client.getFirstName(), client.getLastName());
        clients.put(client1.getId(), client1);
    }

    // muuta createAccount (clientId, accountNr)
    // createAccount (accountNr)
//    @PostMapping("account/create")
//    public void createAccount(@RequestParam String requestName, @RequestParam String requestAddress){
//        String sql = "INSERT INTO customer (name, address)" + "VALUES (:muutuja1, :muutuja2)";
//        Map<String,String> paramMap = new HashMap<>();
//        paramMap.put("muutuja1", requestName);
//        paramMap.put("muutuja2", requestAddress);
//        jdbcTemplate.update(sql, paramMap);
//    }

    @PostMapping("account/create")
    public void createAccount(@RequestBody Account account) {
        Account account1 = new Account(account.getId(), account.getAccountNr(), BigDecimal.ZERO);
        Client a = clients.get(account.getId());
        a.clientAccounts.add(account1);
        map.put(account1.getAccountNr(), account1);
    }

    @GetMapping("client")
    public Map<String, Client> getClients() {
        return clients;
    }


    // getBalanceHistory(accountNr)
}
