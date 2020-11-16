package ee.bcs.valiit.tasks.bank.Service;

import ee.bcs.valiit.tasks.bank.Objects.History;
import ee.bcs.valiit.tasks.bank.Repository.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepo historyRepo;

    public void createHistory(String accountNr) {
        historyRepo.createHistory(accountNr);
    }

    public void depositeHistory(String fromAccountNr, BigDecimal money) {
        historyRepo.updateHistory(fromAccountNr, null, money, "deposit");
    }

    public void withdrawHistory(String fromAccountNr, BigDecimal money) {
        BigDecimal newMoney = BigDecimal.ZERO.subtract(money);
        historyRepo.updateHistory(fromAccountNr, null, newMoney, "withdraw");
    }

    public void transferHistory(String fromAccount, String toAccount, BigDecimal money){
        historyRepo.updateHistory(fromAccount, toAccount, money, "transfer");
    }

    public List<History> getHistory(){
        List<History> result = historyRepo.getHistory();
        return result;
    }
}
