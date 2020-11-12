package ee.bcs.valiit.tasks.bank.RowMapper;


import ee.bcs.valiit.tasks.bank.Objects.Account;
import ee.bcs.valiit.tasks.bank.Objects.AccountForClient;
import liquibase.pro.packaged.A;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAccountRowMapper implements RowMapper<AccountForClient> {
    @Override
    public AccountForClient mapRow(ResultSet resultSet, int i) throws SQLException {
        AccountForClient account = new AccountForClient();
        account.setAccountNr(resultSet.getString("account_nr"));
        return account;
    }
}
