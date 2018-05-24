package org.cxj.di.test;

import org.cxj.di.interf.GreetingsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:consumer-applicationContext.xml"})
public class GreetingsServiceTest {

    @Autowired
    private GreetingsService greetingsService;

    @Test
    public void test(){
        String echo = greetingsService.sayHi("dubbo");
        System.out.println(echo);
    }
}
