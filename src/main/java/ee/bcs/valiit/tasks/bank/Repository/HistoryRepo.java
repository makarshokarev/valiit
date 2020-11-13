package ee.bcs.valiit.tasks.bank.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
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

//    public void updateHistory(String accountNr, BigDecimal money){
//        Map<String, Object> paramMap = new HashMap<>();
//        String sql = "INSERT INTO history (client_id, account_nr, operation, money) VALUES (:m1, :m2, :m3, :m4)";
//        paramMap.put("m1", );
//        paramMap.put("m2", accountNr);
//        paramMap.put("m3", "deposit");
//        paramMap.put("m4", money);
//        jdbcTemplate.update(sql, paramMap);
//    }

    public void insertHistory(){
    }
}
