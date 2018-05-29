package org.cxj.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hello")
    public String hello(){
        return restTemplate.getForEntity("http://API-INTEGRATION/api/hello",String.class).getBody();
    }
}
