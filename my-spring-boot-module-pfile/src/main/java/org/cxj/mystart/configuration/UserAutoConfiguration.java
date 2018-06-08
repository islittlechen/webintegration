package org.cxj.mystart.configuration;

import org.cxj.mystart.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAutoConfiguration {

    @Bean
    public UserService getUserService(){
        return new UserService();
    }
}
