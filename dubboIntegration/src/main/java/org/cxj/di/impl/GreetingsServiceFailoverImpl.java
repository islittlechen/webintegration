package org.cxj.di.impl;

import org.cxj.di.interf.GreetingsService;

import java.util.Random;

public class GreetingsServiceFailoverImpl implements GreetingsService {

    @Override
    public String sayHi(String name) {

        return  "Hi,failover "+name;
    }
}
