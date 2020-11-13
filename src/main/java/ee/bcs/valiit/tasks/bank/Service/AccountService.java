package ee.bcs.valiit.tasks.bank.Service;

import ee.bcs.valiit.tasks.bank.Objects.Account;
import ee.bcs.valiit.tasks.bank.Objects.AccountForClient;
import ee.bcs.valiit.tasks.bank.Repository.AccountRepo;
import ee.bcs.valiit.tasks.bank.Repository2.AccountRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {


    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepo accountRepo;


    public void createAccount(String accountNr, int userId) {
        accountRepo.createAccount(accountNr, userId);
    }

    public List<Account> getAccount() {
        List<Account> result = accountRepo.getAccount();
        return result;
    }

    public void depositMoney(String accountNr, BigDecimal money) {
        BigDecimal getBalance = accountRepo.getBalance(accountNr);
        BigDecimal newBalance = getBalance.add(money);
        accountRepo.setBalance(accountNr, newBalance);
    }

    public void withdrawMoney(String accountNr, BigDecimal money) {
        BigDecimal getBalance = accountRepo.getBalance(accountNr);
        BigDecimal newBalance = getBalance.subtract(money);
        accountRepo.setBalance(accountNr, newBalance);
    }

    public void transferMoney(String fromAccount, String toAccount, BigDecimal money) {
        BigDecimal fromBalance = accountRepo.getBalance(fromAccount);
        BigDecimal toBalance = accountRepo.getBalance(toAccount);

        BigDecimal newBalanceFrom = fromBalance.subtract(money);
        BigDecimal newBalanceTo = toBalance.add(money);

        accountRepo.setBalance(fromAccount, newBalanceFrom);
        accountRepo.setBalance(toAccount, newBalanceTo);
    }

//    public List<AccountForClient> getAccountRepo(){
//        List<AccountForClient> list = accountRepo.getAccountRepo();
//        return list;
//    }


}

