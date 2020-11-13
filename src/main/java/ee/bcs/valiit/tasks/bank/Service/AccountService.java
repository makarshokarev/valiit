package ee.bcs.valiit.tasks.bank.Service;

import ee.bcs.valiit.tasks.bank.Exception.ApplicationException;
import ee.bcs.valiit.tasks.bank.Objects.Account;
import ee.bcs.valiit.tasks.bank.Objects.History;
import ee.bcs.valiit.tasks.bank.Repository.AccountRepo;
import ee.bcs.valiit.tasks.bank.Repository.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private HistoryRepo historyRepo;

    public void createAccount(String accountNr, int userId) {
        try {
            accountRepo.createAccount(accountNr, userId);
        } catch (EmptyResultDataAccessException e){
            throw new ApplicationException("Wrong input!");
        }
    }

    public List<Account> getAccount() {
        List<Account> result = accountRepo.getAccounts();
        return result;
    }

    public BigDecimal balance(String accountNr){
        try {
            BigDecimal getBalance = accountRepo.getBalance(accountNr);
            return getBalance;
        } catch (EmptyResultDataAccessException e){
            throw new ApplicationException("Wrong account number!");
        }
    }

    public void depositMoney(String accountNr, BigDecimal money) {
        try {
            BigDecimal getBalance = accountRepo.getBalance(accountNr);
            BigDecimal newBalance = getBalance.add(money);
            accountRepo.setBalance(accountNr, newBalance);
        } catch (EmptyResultDataAccessException e){
            throw new ApplicationException("Wrong input!");
        }
    }

    public void withdrawMoney(String accountNr, BigDecimal money) {
        try {
            BigDecimal getBalance = accountRepo.getBalance(accountNr);
            BigDecimal newBalance = getBalance.subtract(money);
            accountRepo.setBalance(accountNr, newBalance);
        } catch (EmptyResultDataAccessException e){
            throw new ApplicationException("Wrong input!");
        }
    }

    public void transferMoney(String fromAccount, String toAccount, BigDecimal money) {
        BigDecimal fromBalance = accountRepo.getBalance(fromAccount);
        BigDecimal toBalance = accountRepo.getBalance(toAccount);

        BigDecimal newBalanceFrom = fromBalance.subtract(money);
        BigDecimal newBalanceTo = toBalance.add(money);

        accountRepo.setBalance(fromAccount, newBalanceFrom);
        accountRepo.setBalance(toAccount, newBalanceTo);
    }


}

