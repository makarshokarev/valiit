package ee.bcs.valiit.tasks.bank.RowMapper;

import ee.bcs.valiit.tasks.bank.Objects.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getString("id"));
        account.setAccountNr(resultSet.getString("account_nr"));
        account.setMoney(resultSet.getBigDecimal("balance"));
        account.setUserId(resultSet.getInt("client_id"));
        return account;
    }
}
