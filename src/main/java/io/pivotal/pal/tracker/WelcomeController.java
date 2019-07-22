package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String welcome_message;

    @Autowired
    private Environment env;

    /*
    WelcomeController(@Value("${welcome.message}") String welmsg )
    {
        welcome_message = welmsg;
    }
    */
    @GetMapping("/")
    public String sayHello() {
        return  env.getProperty("WELCOME_MESSAGE");
    }
}
