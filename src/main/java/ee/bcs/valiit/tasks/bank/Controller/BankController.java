package ee.bcs.valiit.tasks.bank.Controller;

import ee.bcs.valiit.tasks.bank.Account;
import ee.bcs.valiit.tasks.bank.AccountBalance;
import ee.bcs.valiit.tasks.bank.Service.AccountService;
import ee.bcs.valiit.tasks.bank.Client;
import ee.bcs.valiit.tasks.bank.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("bank")
@RestController
public class BankController {

    @Autowired
            private AccountService accountService;

    @Autowired
            private ClientService clientService;

    @Autowired
            private NamedParameterJdbcTemplate jdbcTemplate;

//    Map<String, Account> map = new HashMap<>();
//    Map<String, Client> clients = new HashMap<>();

    // depositMoney (accountNr, money)
    @PutMapping("account/deposit")
    public void depositMoney(@RequestBody Account account) {
        accountService.depositMoney(account);
    }

    // withdrawMoney (accountNr, money)
    @PutMapping("account/withdraw")
    public void withdrawMoney(@RequestBody Account account) {
        accountService.withdrawMoney(account);
    }

    // transferMoney (fromAccount, toAccount, money)
    @PutMapping("account/transfer")
    public void transferMoney(@RequestBody AccountBalance transfer) {
        accountService.transferMoney(transfer);
//        Account fromAccount = map.get(transfer.getFromAccount());
//        Account toAccount = map.get(transfer.getToAccount());
//        BigDecimal newBalance1 = fromAccount.getMoney().subtract(transfer.getMoney());
//        BigDecimal newBalance2 = toAccount.getMoney().add(transfer.getMoney());
//        fromAccount.setMoney(newBalance1);
//        toAccount.setMoney(newBalance2);
    }

    // getAccountBalance (accountNr)
//    @GetMapping("account/balance")
//    public String getBalance(@RequestBody Account account) {
//        Account mapAccount = map.get(account.getAccountNr());
//        BigDecimal balance = mapAccount.getMoney();
//        return "Account:" + account.getAccountNr() + ", Balance:" + balance;
//    }
    // Raskem
    // createClient(firstName lastName, ....)

    @PostMapping("client/create")
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client);
    }

    @PostMapping("account/create")
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @GetMapping("client")
    public List<Client> getClient() {
        List<Client> result = clientService.getClient();
        return result;
    }

    @GetMapping("account")
    public List<Account> getAccount() {
        List<Account> result = accountService.getAccout();
        return result;
    }

    // getBalanceHistory(accountNr)
}
