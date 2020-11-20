package ee.bcs.valiit.tasks.bank.controller;

import ee.bcs.valiit.tasks.bank.objects.*;
import ee.bcs.valiit.tasks.bank.repository.AccountRepo;
import ee.bcs.valiit.tasks.bank.service.AccountService;
import ee.bcs.valiit.tasks.bank.service.ClientService;
import ee.bcs.valiit.tasks.bank.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    private AccountRepo accountRepo;

//    @GetMapping("hibernate-test")
//    public void getAllAccount(){
////        Account obj = new Account();
////        obj.setAccountNr("EE999");
////        obj.setBalance(BigDecimal.valueOf(500));
////        obj.setClientId(2l);
//        accountRepository2.deleteById(14l);
//    }

    // depositMoney (accountNr, money)
    @PutMapping("account/deposit")
    @CrossOrigin
    public PopUpWindow depositMoney(@RequestBody Account account) {
        accountService.depositMoney(account.getAccountNr(), account.getMoney());
        historyService.depositeHistory(account.getAccountNr(), account.getMoney());
        return new PopUpWindow("Deposited " + account.getMoney() + "$ to account " + account.getAccountNr());
    }

    // withdrawMoney (accountNr, money)
    @CrossOrigin
    @PutMapping("account/withdraw")
    public PopUpWindow withdrawMoney(@RequestBody Account account) {
        accountService.withdrawMoney(account.getAccountNr(), account.getMoney());
        historyService.withdrawHistory(account.getAccountNr(),account.getMoney());
        return new PopUpWindow(account.getMoney() + "$ was withfrawn from " + account.getAccountNr());
    }

    // transferMoney (fromAccount, toAccount, money)
    @CrossOrigin
    @PutMapping("account/transfer")
    public PopUpWindow transferMoney(@RequestBody TransferBalance transfer) {
        accountService.transferMoney(transfer.getFromAccount(), transfer.getToAccount(), transfer.getMoney());
        historyService.transferHistory(transfer.getFromAccount(), transfer.getToAccount(), transfer.getMoney());
        return new PopUpWindow(transfer.getMoney() + "$ was transfered from " + transfer.getFromAccount() + " to " + transfer.getToAccount());
    }

    // getAccountBalance (accountNr)
    @GetMapping("account/balance")
    @CrossOrigin
    public BigDecimal getBalance(@RequestBody Balance balance) {
        return accountService.balance(balance.getAccountNr());
    }

    @PostMapping("client/create")
    @CrossOrigin
    public PopUpWindow createClient(@RequestBody CreateClient createClient) {
        clientService.createClient(createClient.getFirstName(), createClient.getLastName());
        return new PopUpWindow("Created client " + createClient.getFirstName() + " " + createClient.getLastName());
    }

    @PostMapping("account/create")
    @CrossOrigin
    public PopUpWindow createAccount(@RequestBody CreateAccount createAccount) {
        accountService.createAccount(createAccount.getAccountNr(), createAccount.getClientId());
        historyService.createHistory(createAccount.getAccountNr());
        return new PopUpWindow("Created account " + createAccount.getAccountNr() + " for client nr " + createAccount.getClientId());
    }

    @GetMapping("client")
    @CrossOrigin
    public List<Client> getClient() {
        List<Client> result = clientService.getClient();
        return result;
    }

    @GetMapping("account")
    @CrossOrigin
    public List<Account> getAccount() {
        List<Account> result = accountService.getAccount();
        return result;
    }

//    @GetMapping("test")
//    public void getTest(@RequestBody Account account){
//        accountRepo.selectAcc(account.getAccountNr());
//    }

    @GetMapping("history")
    @CrossOrigin
    public List<History> getHistory(){
        List<History> result = historyService.getHistory();
        return result;
    }

    @CrossOrigin
    @PostMapping("register")
    public List<User> register(@RequestBody User user){
        System.out.println(user);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(new User("john", "jhon@mail.ru", 27 ));
        userList.add(new User("tallinn", "tallinn@gmail", 43));
        userList.add(new User("moscow", "moscow@ru", 34));
        userList.add(new User("helsinki", "helsinki@fi", 32));
        return userList;
    }
}
