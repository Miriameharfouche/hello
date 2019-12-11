package com.emse.spring.faircop.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService {
    @Autowired
    GreetingService greetingService;
public DummyUserService(GreetingService greetingService){
    this.greetingService=greetingService;
}
    @Override
    public void greetAll() {
        String[] names={"Elodie","Chales"};
        for(String name:names )
            greetingService.greet(name);
        }
    }

