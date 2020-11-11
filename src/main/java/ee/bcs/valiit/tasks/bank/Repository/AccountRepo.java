package ee.bcs.valiit.tasks.bank.Repository;

import ee.bcs.valiit.tasks.bank.Account;
import ee.bcs.valiit.tasks.bank.AccountBalance;
import ee.bcs.valiit.tasks.bank.RowMapper.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepo {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public BigDecimal selectId(Account account){
        Map<String, Object> paramMap = new HashMap<>();
        String sql1 = "SELECT id FROM customer WHERE id = :m1";
        paramMap.put("m1", account.getUserId());
        BigDecimal clientId = jdbcTemplate.queryForObject(sql1, paramMap, BigDecimal.class);
        return clientId;
    }

    public void createAccount(Account account){
        Map<String, Object> paramMap = new HashMap<>();
        String sql = "INSERT INTO account (account_nr, balance, client_id) VALUES (:m1, :m2, :m3)";
        paramMap.put("m1", account.getAccountNr());
        paramMap.put("m2", BigDecimal.ZERO);
        paramMap.put("m3", selectId(account));
        jdbcTemplate.update(sql, paramMap);
    }

    public List<Account> getAccount(){
        String sql = "SELECT * FROM account";
        Map<String, Object> paramMap = new HashMap<>();
        List<Account> result = jdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        return result;
    }

    public BigDecimal selectBalance(Account account){
        Map<String, Object> paramMap = new HashMap<>();
        String sql1 = "SELECT balance FROM account WHERE account_nr = :m1";
        paramMap.put("m1", account.getAccountNr());
        BigDecimal balance = jdbcTemplate.queryForObject(sql1, paramMap, BigDecimal.class);
        return balance;
    }

    public void deposit(Account account){
        Map<String, Object> paramMap = new HashMap<>();
        BigDecimal newBalance = account.getMoney().add(selectBalance(account));
        String sql = "UPDATE account SET balance = :m1 WHERE account_nr = :m2";
        paramMap.put("m1", newBalance);
        paramMap.put("m2", account.getAccountNr());
        jdbcTemplate.update(sql, paramMap);
    }

    public void withdraw(Account account){
        Map<String, Object> paramMap = new HashMap<>();
        BigDecimal newBalance = selectBalance(account).subtract(account.getMoney());
        String sql2 = "UPDATE account SET balance = :m2 WHERE account_nr = :m3";
        paramMap.put("m2", newBalance);
        paramMap.put("m3", account.getAccountNr());
        jdbcTemplate.update(sql2, paramMap);
    }

    public BigDecimal fromBalance(AccountBalance transfer){
        Map<String, Object> paramMap = new HashMap<>();
        String sql = "SELECT balance FROM account WHERE account_nr = :m1";
        paramMap.put("m1", transfer.getFromAccount());
        BigDecimal fromBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        return fromBalance;
    }

    public BigDecimal toBalance(AccountBalance transfer){
        Map<String, Object> paramMap = new HashMap<>();
        String sql = "SELECT balance FROM account WHERE account_nr = :m1";
        paramMap.put("m1", transfer.getToAccount());
        BigDecimal toBalance = jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        return toBalance;
    }

    public void newFromBalance(AccountBalance transfer){
        Map<String, Object> paramMap = new HashMap<>();
        BigDecimal newBalance = toBalance(transfer).add(transfer.getMoney());
        String sql = "UPDATE account SET balance = :m2 WHERE account_nr = :m1";
        paramMap.put("m1", transfer.getToAccount());
        paramMap.put("m2", newBalance);
        jdbcTemplate.update(sql, paramMap);
    }

    public void newToBalance(AccountBalance transfer){
        Map<String, Object> paramMap = new HashMap<>();
        BigDecimal newBalance = fromBalance(transfer).subtract(transfer.getMoney());
        String sql = "UPDATE account SET balance = :m2 WHERE account_nr = :m1";
        paramMap.put("m1", transfer.getToAccount());
        paramMap.put("m2", newBalance);
        jdbcTemplate.update(sql, paramMap);
    }
}
