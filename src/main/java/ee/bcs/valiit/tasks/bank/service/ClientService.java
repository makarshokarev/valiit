package ee.bcs.valiit.tasks.bank.service;


import ee.bcs.valiit.tasks.bank.objects.Client;
import ee.bcs.valiit.tasks.bank.repository.AccountRepo;
import ee.bcs.valiit.tasks.bank.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private AccountRepo accountRepo;

    public void createClient(String firstName, String lastName) {
        clientRepo.createClient(firstName, lastName);
    }

    public List<Client> getClient() {
        List<Client> result = clientRepo.getClient();
        for(int i = 0; i < result.size(); i++){
            List<String> accountList = accountRepo.getAccountByClient(result.get(i).getId());
            result.get(i).setClientAccounts(accountList);
        }
        return result;
    }

}
