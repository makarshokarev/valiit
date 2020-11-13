package ee.bcs.valiit.tasks.bank.Service;

import ee.bcs.valiit.tasks.bank.Objects.History;
import ee.bcs.valiit.tasks.bank.Repository.AccountRepo;
import ee.bcs.valiit.tasks.bank.Repository.ClientRepo;
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

//    public void updateHistory(String accountNr, BigDecimal money) {
//        historyRepo.updateHistory(accountNr, money);
//    }

//    public List<History> getHistory(){
//        List<History> result = historyRepo.createHistory();
//        return result;
//    }
}
