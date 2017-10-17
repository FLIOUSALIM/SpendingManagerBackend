package org.melsif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fliou on 12/10/17.
 */

@SpringBootApplication
@Controller
public class SpendingManagerApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(SpendingManagerApplication.class);

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "hello world";
    }

    public static void main(String[] args) {
        LOGGER.info("SpendingManagerApplication starting ...");
        SpringApplication.run(SpendingManagerApplication.class, args);
        LOGGER.info("SpendingManagerApplication started");
    }
}
