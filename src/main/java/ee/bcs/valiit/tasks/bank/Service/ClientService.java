package ee.bcs.valiit.tasks.bank.Service;

import ee.bcs.valiit.tasks.bank.Client;
import ee.bcs.valiit.tasks.bank.Repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    public void createClient(Client client) {
        clientRepo.createClient(client);

    }
    public List<Client> getClient() {
        List<Client> result = clientRepo.getClient();
        return result;
    }
}
