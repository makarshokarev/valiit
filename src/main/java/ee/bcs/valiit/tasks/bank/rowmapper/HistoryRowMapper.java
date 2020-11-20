package ee.bcs.valiit.tasks.bank.rowmapper;

import ee.bcs.valiit.tasks.bank.objects.History;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryRowMapper implements RowMapper<History> {
    @Override
    public History mapRow(ResultSet resultSet, int i) throws SQLException {
        History history = new History();
        history.setFromAccountNr(resultSet.getString("from_account_nr"));
        history.setToAccountNr(resultSet.getString("to_account_nr"));
        history.setOperation(resultSet.getString("operation"));
        history.setMoney(resultSet.getBigDecimal("money"));
        return history;
    }
}
