package com.yaas.recoderuserservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/status"})
public class StatusController {
    @Autowired
    Environment env;

    @GetMapping({"/check"})
    public String status() {
        return String.format("users service > Working on port %s", new Object[] { this.env.getProperty("local.server.port") });
    }
}
