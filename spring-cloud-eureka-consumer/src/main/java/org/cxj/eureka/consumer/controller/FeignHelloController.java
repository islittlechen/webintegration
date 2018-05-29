package org.cxj.eureka.consumer.controller;

import org.cxj.eureka.consumer.inter.HelloApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHelloController {

    @Autowired
    private HelloApiClient helloApiClient;

    @RequestMapping("/configInfo")
    public String showConfigInfo(){
        return helloApiClient.apiConfigInfo();
    }
}
