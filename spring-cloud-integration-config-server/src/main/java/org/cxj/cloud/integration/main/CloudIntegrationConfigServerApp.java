package org.cxj.cloud.integration.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CloudIntegrationConfigServerApp {

    public static void main(String[] args){
        SpringApplication.run(CloudIntegrationConfigServerApp.class,args);
    }
}
