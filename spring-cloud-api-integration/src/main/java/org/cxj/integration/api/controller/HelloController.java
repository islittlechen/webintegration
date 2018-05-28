package org.cxj.integration.api.controller;

import org.cxj.integration.api.settings.ApiConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${api.hello}")
    private String hello;


    @Autowired
    private ApiConfiguration apiConfiguration;


    @RequestMapping("/api/hello")
    public String echo(){
        return this.hello;
    }

    @RequestMapping("api/configInfo")
    public String apiConfigInfo(){
        return this.apiConfiguration.getApiName()+","+this.apiConfiguration.getMaxExec();
    }
}
