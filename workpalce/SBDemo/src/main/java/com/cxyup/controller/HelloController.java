package com.cxyup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {
public final Logger log=LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/hello")
    public ResponseEntity helloWorld(String message){
        log.info(message);
        log.error(message);
        log.debug(message);
        return ResponseEntity.ok(message);
    }
}
