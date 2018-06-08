package org.cxj.bus.kafka.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"org.cxj.bus.kafka.controller"})
public class BusKafkaClientApplication {

    public static void main(String[] args){
        SpringApplication.run(BusKafkaClientApplication.class,args);
    }

}
