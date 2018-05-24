package org.cxj.di.test;

import org.cxj.di.interf.GreetingsService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class CurrencyTest {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer-applicationContext.xml");
        context.start();
        final GreetingsService service = (GreetingsService)context.getBean("greetingsService");
        new Thread(){
            @Override
            public void run() {
                int seq = 1;
               while(true){
                   String echo = service.sayHi("invoke-1-"+seq);
                  System.out.println(echo);
               }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                int seq = 1;
                while(true){
                    String echo = service.sayHi("invoke-2-"+seq);
                   System.out.println(echo);
                }
            }
        }.start();
    }
}
