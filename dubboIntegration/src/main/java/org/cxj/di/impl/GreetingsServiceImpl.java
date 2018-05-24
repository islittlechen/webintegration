package org.cxj.di.impl;

import org.cxj.di.interf.GreetingsService;

import java.util.Random;

public class GreetingsServiceImpl implements GreetingsService {

    @Override
    public String sayHi(String name) {
        Random random = new Random();
        try {
            Thread.sleep(Math.abs(random.nextInt(4))*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2+"Hi,"+name;
    }
}
