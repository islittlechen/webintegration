package org.cxj.integration.api.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@EnableHystrix
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
@ComponentScan({"org.cxj.integration.api"})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
