package com.gustavo.demogithubactions.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        LOGGER.info("hello endpoint");
        return "Hello World!";
    }

    @GetMapping("/goodbye")
    @ResponseStatus(HttpStatus.OK)
    public String goodbye() {
        LOGGER.info("goodbye endpoint");
        return "Goodbye!";
    }

}
