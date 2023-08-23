package performance.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import performance.Application;
import performance.config.ExceptionHandlerAdvice;
import performance.exception.CountryNotDefinedException;
import performance.exception.CountryNotSupportedException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {Scenario4Controller.class, ExceptionHandlerAdvice.class})
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@ExtendWith(MockitoExtension.class)
@ImportAutoConfiguration(ExceptionHandlerAdvice.class)
@Disabled("Conditional does not work with prototype scoped beans")
public class Scenario4WorkaroundControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void restCallWithHeaderXCountryWithValueCH() throws Exception {
        mockMvc.perform(get("/scenario4workaround")
                .header("X-Country", "CH"))
            .andExpect(status().isOk())
            .andExpect(content().string("Speed limit is 50 km/h in city and 120 km/h on highway"));
    }

    @Test
    public void restCallWithHeaderXCountryWithValueDE() throws Exception {
        mockMvc.perform(get("/scenario4workaround")
                .header("X-Country", "DE"))
            .andExpect(status().isOk())
            .andExpect(content().string("Speed limit is 50 km/h in city and 200 km/h on highway"));
    }

    @Test
    public void restCallWithHeaderXCountryWithValidValueLowercase() throws Exception {
        mockMvc.perform(get("/scenario4workaround").header("X-Country", "ch")).andExpect(status().isOk());
    }

    @Test
    public void restCallWithHeaderXCountryWithValueUS() {
        assertThrows(CountryNotSupportedException.class, () ->
            mockMvc.perform(get("/scenario4workaround").header("X-Country", "US")));
    }

    @Test
    public void restCallWithNoHeader() {
        assertThrows(CountryNotDefinedException.class, () ->
            mockMvc.perform(get("/scenario4workaround")));
    }


}
