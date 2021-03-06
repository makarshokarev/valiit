package ee.bcs.valiit.tasks.bank.repository;

import ee.bcs.valiit.tasks.bank.objects.Account;
import ee.bcs.valiit.tasks.bank.rowmapper.AccountRowMapper;
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

    public BigDecimal selectId(int userId) {
        Map<String, Object> paramMap = new HashMap<>();
        String sql1 = "SELECT id FROM customer WHERE id = :m1";
        paramMap.put("m1", userId);
        BigDecimal clientId = jdbcTemplate.queryForObject(sql1, paramMap, BigDecimal.class);
        return clientId;
    }

    public String selectAcc(String accountNr){
        Map<String, Object> paramMap = new HashMap<>();
        String sql = "SELECT account_nr FROM account WHERE account_nr = :m1 LIMIT 1";
        paramMap.put("m1", accountNr);
        String accNr = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return accNr;
    }

    public boolean doesAccountExisst(String accountNr){
        String sql = "SELECT count(*) from account where account_nr = :nr";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("nr", accountNr);
        Integer count = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return count > 0;
    }

    public void createAccount(String accountNr, int clientId) {
        Map<String, Object> paramMap = new HashMap<>();
        String sql = "INSERT INTO account (account_nr, balance, client_id) VALUES (:m1, :m2, :m3)";
        paramMap.put("m1", accountNr);
        paramMap.put("m2", BigDecimal.ZERO);
        paramMap.put("m3", selectId(clientId));
        jdbcTemplate.update(sql, paramMap);
    }

    public List<Account> getAccounts() {
        String sql = "SELECT * FROM account";
        Map<String, Object> paramMap = new HashMap<>();
        List<Account> result = jdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        return result;
    }

    public BigDecimal getBalance(String accountNr) {
        Map<String, Object> paramMap = new HashMap<>();
        String sql1 = "SELECT balance FROM account WHERE account_nr = :m1";
        paramMap.put("m1", accountNr);
        BigDecimal balance = jdbcTemplate.queryForObject(sql1, paramMap, BigDecimal.class);
        return balance;
    }

    public void setBalance(String accountNr, BigDecimal newBalance) {
        Map<String, Object> paramMap = new HashMap<>();
        String sql2 = "UPDATE account SET balance = :m1 WHERE account_nr = :m2";
        paramMap.put("m1", newBalance);
        paramMap.put("m2", accountNr);
        jdbcTemplate.update(sql2, paramMap);
    }


    public List<String> getAccountByClient(int id) {
        String sql = "SELECT account_nr FROM account WHERE client_id = :m1";
        //String sql = "SELECT account_nr FROM account a JOIN customer c ON a.client_id = c.id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("m1", id);
        List<String> result = jdbcTemplate.queryForList(sql, paramMap, String.class);
        return result;
    }
}
