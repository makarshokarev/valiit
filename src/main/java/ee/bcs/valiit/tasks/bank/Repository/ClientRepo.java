package ee.bcs.valiit.tasks.bank.Repository;

import ee.bcs.valiit.tasks.bank.Objects.Client;
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

    public void createClient(String firstName, String lastName){
        String sql = "INSERT INTO customer (first_name, last_name) VALUES (:m1, :m2)";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("m1", firstName);
        paramMap.put("m2", lastName);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<Client> getClient(){
        String sql = "SELECT * FROM customer";
        Map<String, Object> paramMap = new HashMap();
        List<Client> result = jdbcTemplate.query(sql, paramMap, new ClientRowMapper());
        return result;
    }



}
