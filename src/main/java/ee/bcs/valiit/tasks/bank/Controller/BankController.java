package ee.bcs.valiit.tasks.bank.Controller;

import ee.bcs.valiit.tasks.bank.Objects.*;
import ee.bcs.valiit.tasks.bank.Repository2.AccountRepository2;
import ee.bcs.valiit.tasks.bank.Service.AccountService;
import ee.bcs.valiit.tasks.bank.Service.ClientService;
import ee.bcs.valiit.tasks.bank.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("bank")
@RestController
public class BankController {


    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepository2 accountRepository2;

    @GetMapping("hibernate-test")
    public void getAllAccount(){
//        Account obj = new Account();
//        obj.setAccountNr("EE999");
//        obj.setBalance(BigDecimal.valueOf(500));
//        obj.setClientId(2l);
        accountRepository2.deleteById(14l);
    }

    // depositMoney (accountNr, money)
    @PutMapping("account/deposit")
    public void depositMoney(@RequestBody ee.bcs.valiit.tasks.bank.Objects.Account account) {
        accountService.depositMoney(account.getAccountNr(), account.getMoney());
        //historyService.updateHistory(account.getAccountNr(), account.getMoney());
    }

    // withdrawMoney (accountNr, money)
    @PutMapping("account/withdraw")
    public void withdrawMoney(@RequestBody ee.bcs.valiit.tasks.bank.Objects.Account account) {
        accountService.withdrawMoney(account.getAccountNr(), account.getMoney());
    }

    // transferMoney (fromAccount, toAccount, money)
    @PutMapping("account/transfer")
    public void transferMoney(@RequestBody TransferBalance transfer) {
        accountService.transferMoney(transfer.getFromAccount(), transfer.getToAccount(), transfer.getMoney());
    }

    // getAccountBalance (accountNr)
    @GetMapping("account/balance")
    public BigDecimal getBalance(@RequestBody Balance balance) {
        return accountService.balance(balance.getAccountNr());
//        Account mapAccount = map.get(account.getAccountNr());
//        BigDecimal balance = mapAccount.getMoney();
//        return "Account:" + account.getAccountNr() + ", Balance:" + balance;
    }

    @PostMapping("client/create")
    public void createClient(@RequestBody CreateClient createClient) {
        clientService.createClient(createClient.getFirstName(), createClient.getLastName());
    }

    @PostMapping("account/create")
    public void createAccount(@RequestBody CreateAccount createAccount) {
        accountService.createAccount(createAccount.getAccountNr(), createAccount.getClientId());
        historyService.createHistory(createAccount.getAccountNr());
    }

    @GetMapping("client")
    public List<Client> getClient() {
        List<Client> result = clientService.getClient();
        return result;
    }

    @GetMapping("account")
    public List<ee.bcs.valiit.tasks.bank.Objects.Account> getAccount() {
        List<ee.bcs.valiit.tasks.bank.Objects.Account> result = accountService.getAccount();
        return result;
    }

//    @GetMapping("history")
//    public List<History> getHistory(){
//        List<History> result = historyService.getHistory();
//        return result;
//    }

//    @GetMapping("test")
//    public  List<AccountForClient> getAccountRepo(){
//        List<AccountForClient> result = accountService.getAccountRepo();
//        return result;
//    }

    // getBalanceHistory(accountNr)
}
