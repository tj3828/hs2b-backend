package com.hs2b.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class EnvControllers {

    @Autowired
    Environment environment;

    @GetMapping("/api/port")
    public String getCurrentPort() {
        return environment.getProperty("server.port");
    }
}
