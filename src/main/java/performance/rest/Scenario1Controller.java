package performance.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scenario1")
public class Scenario1Controller {

    @RequestMapping
    public String index() {
        return "scenario1";
    }

}