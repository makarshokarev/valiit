package ee.bcs.valiit.tasks.bank.Repository;

import ee.bcs.valiit.tasks.bank.Objects.History;
import ee.bcs.valiit.tasks.bank.RowMapper.HistoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HistoryRepo {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void createHistory(String fromAccountNr){
        Map<String, Object> paramMap = new HashMap<>();
        String sql = "INSERT INTO history (from_account_nr, operation, money) VALUES (:m1, :m2, :m3)";
        paramMap.put("m1", fromAccountNr);
        paramMap.put("m2", "creation");
        paramMap.put("m3", BigDecimal.ZERO);
        jdbcTemplate.update(sql, paramMap);
    }

    public void updateHistory(String fromAccountNr, String toAccountNr, BigDecimal money, String operation){
        Map<String, Object> paramMap = new HashMap<>();
        String sql = "INSERT INTO history (from_account_nr, to_account_nr, operation, money) VALUES (:m1, :m2, :m3, :m4)";
        paramMap.put("m1", fromAccountNr);
        paramMap.put("m2", toAccountNr);
        paramMap.put("m3", operation);
        paramMap.put("m4", money);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<History> getHistory(){
        String sql = "SELECT * FROM history";
        Map<String, Object> paramMap = new HashMap<>();
        List<History> result = jdbcTemplate.query(sql, paramMap, new HistoryRowMapper());
        return result;
    }
}
