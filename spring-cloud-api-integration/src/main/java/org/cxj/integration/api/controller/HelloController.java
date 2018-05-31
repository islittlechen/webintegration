package org.cxj.integration.api.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "fallbackMethod") //Hystrix服务降级
    public String echo(){
        if(System.currentTimeMillis() % 2 ==0 ){
            throw new RuntimeException("测试服务降级功能");
        }
        return this.hello;
    }

    @RequestMapping("api/configInfo")
    public String apiConfigInfo(){
        return this.apiConfiguration.getApiName()+","+this.apiConfiguration.getMaxExec();
    }

    public String fallbackMethod(){
        return "fallbackMethod invoked";
    }
}
