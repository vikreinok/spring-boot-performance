package performance.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import performance.Application;
import performance.exception.CountryNotSupportedException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class TestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void restCallWithHeaderXCountryWithValueCH() throws Exception {
        mockMvc.perform(
                get("/").header("X-Country", "CH")
        )
               .andExpect(status().isOk())
               .andExpect(content().string("Speed limit is 50 km/h in city and 120 km/h on highway"));
    }

    @Test
    public void restCallWithHeaderXCountryWithValueDE() throws Exception {
        mockMvc.perform(
                get("/").header("X-Country", "DE")
        ).andExpect(status().isOk())
               .andExpect(content().string("Speed limit is 50 km/h in city and 200 km/h on highway"));
    }

    @Test
    public void restCallWithHeaderXCountryWithValueUs() throws Exception {
        mockMvc.perform(
                get("/").header("X-Country", "US")

//        ).andExpect(status().is5xxServerError());
        ).andDo(print())
               .andExpect(result -> assertTrue(result.getResolvedException() instanceof CountryNotSupportedException));
    }

    @Test
    public void restCallWithNoHeader() throws Exception {
        mockMvc.perform(
                get("/")
        ).andDo(print())
               .andExpect(status().is5xxServerError());
    }


}