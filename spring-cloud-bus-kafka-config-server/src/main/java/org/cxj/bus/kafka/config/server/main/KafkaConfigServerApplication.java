package org.cxj.bus.kafka.config.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class KafkaConfigServerApplication {

    public static void main(String[] args){
        SpringApplication.run(KafkaConfigServerApplication.class,args);
    }
}
