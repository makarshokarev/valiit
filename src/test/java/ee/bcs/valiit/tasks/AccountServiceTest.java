package ee.bcs.valiit.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AccountServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void registrationWorksThroughAllLayers() throws Exception{

        mockMvc.perform(get("/bank/client")
            .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Russia"));
    }
}
