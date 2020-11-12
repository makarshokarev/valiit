package ee.bcs.valiit.tasks.bank.RowMapper;


import ee.bcs.valiit.tasks.bank.Objects.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getInt("id"));
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        return client;
    }
}
