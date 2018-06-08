package org.cxj.bus.kafka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class BusRefreshController {

    @Value("${api.hello}")
    private String apiName;

    @RequestMapping("/bus/test")
    public String test(){
        return this.apiName;
    }
}
