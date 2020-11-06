package ee.bcs.valiit.tasks.controller;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank")
@RestController
public class BankController {

    Map<String, BigDecimal> map = new HashMap<>();

    // show created accounts
    @GetMapping("account")
    public Map<String, BigDecimal> getAccounts(){
        return map;
    }

    // createAccount (accountNr)
    @PostMapping("account/create")
    public void createAccount(@RequestBody Account account){
        map.put(account.getAccountNr(), account.getMoney());
    }

    // depositMoney (accountNr, money)
    @PutMapping("account/deposit")
    public BigDecimal depositMoney(@RequestBody Account account){
        BigDecimal newBalance = account.deposit(map.get(account.getAccountNr()));
        return map.put(account.getAccountNr(), newBalance);
    }

    // withdrawMoney (accountNr, money)
    @PutMapping("account/withdraw")
    public BigDecimal withdrawMoney(@RequestBody Account account){
        BigDecimal newBalance = account.withdraw(map.get(account.getAccountNr()));//nado perevernutj
        return map.put(account.getAccountNr(), newBalance);
    }
    // transferMoney (fromAccount, toAccount, money)
    // getAccountBalance (accountNr)

    // Raskem
    // createClient(firstName lastName, ....)
    // muuta createAccount (clientId, accountNr)
    // getBalanceHistory(accountNr)
}
