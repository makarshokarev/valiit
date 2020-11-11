package ee.bcs.valiit.tasks.bank.Service;

import ee.bcs.valiit.tasks.bank.Account;
import ee.bcs.valiit.tasks.bank.AccountBalance;
import ee.bcs.valiit.tasks.bank.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepo accountRepo;

    public void createAccount(Account account) {
        accountRepo.createAccount(account);
    }

    public List<Account> getAccout() {
        List<Account> result = accountRepo.getAccount();
        return result;
    }

    public void depositMoney(Account account) {
        accountRepo.deposit(account);
    }

    public void withdrawMoney(Account account) {
        accountRepo.withdraw(account);
    }

    public void transferMoney(AccountBalance transfer) {
        accountRepo.newFromBalance(transfer);
        accountRepo.newToBalance(transfer);
//        Map<String, Object> paramMap = new HashMap<>();
//        String sql = "SELECT balance FROM account WHERE account_nr = :m1";
//        String sql2 = "SELECT balance FROM account WHERE account_nr = :m2";
//        paramMap.put("m2", transfer.getFromAccount());
//        paramMap.put("m1", transfer.getToAccount());
//        BigDecimal oldBalance1 = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//        BigDecimal oldBalance2 = jdbcTemplate.queryForObject(sql2, paramMap, BigDecimal.class);
//        BigDecimal newBalance1 = oldBalance1.add(transfer.getMoney());
//        BigDecimal newBalance2 = oldBalance2.subtract(transfer.getMoney());
//        String sql3 = "UPDATE account SET balance = :m3 WHERE account_nr = :m1";
//        String sql4 = "UPDATE account SET balance = :m4 WHERE account_nr = :m2";
//        paramMap.put("m3", newBalance1);
//        paramMap.put("m4", newBalance2);
//        jdbcTemplate.update(sql3, paramMap);
//        jdbcTemplate.update(sql4, paramMap);
    }
}
