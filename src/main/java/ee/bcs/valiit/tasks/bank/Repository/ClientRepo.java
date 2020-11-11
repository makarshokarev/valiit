package ee.bcs.valiit.tasks.bank.Repository;

import ee.bcs.valiit.tasks.bank.Client;
import ee.bcs.valiit.tasks.bank.RowMapper.ClientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClientRepo {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void createClient(Client client){
        String sql = "INSERT INTO customer (first_name, last_name) VALUES (:m1, :m2)";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("m1", client.getFirstName());
        paramMap.put("m2", client.getLastName());
        jdbcTemplate.update(sql, paramMap);
    }

    public List<Client> getClient(){
        String sql = "SELECT * FROM customer";
        Map<String, Object> paramMap = new HashMap();
        List<Client> result = jdbcTemplate.query(sql, paramMap, new ClientRowMapper());
        return result;
    }
}
