package org.cxj.bus.kafka.controller;

import org.cxj.mystart.service.ExampleService;
import org.cxj.mystart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class BusRefreshController {

    @Value("${api.hello}")
    private String apiName;

    @Autowired
    private UserService userService;

    @Autowired
    private ExampleService exampleService;

    @RequestMapping("/bus/test")
    public String test(){
        return this.apiName+userService.helloStarter();
    }

    @RequestMapping("/bus/example")
    public String example(@RequestParam("word") String word){
        return exampleService.wrap(word);
    }
}
