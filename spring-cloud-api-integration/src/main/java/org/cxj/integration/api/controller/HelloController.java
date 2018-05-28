package org.cxj.integration.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${api.hello}")
    private String hello;

    @RequestMapping("/api/hello")
    public String echo(){
        return this.hello;
    }
}
