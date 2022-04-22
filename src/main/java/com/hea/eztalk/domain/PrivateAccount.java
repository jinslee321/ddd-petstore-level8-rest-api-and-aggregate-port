package com.hea.eztalk.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("privateaccount")
public class PrivateAccount extends Account implements Runnable {

    public PrivateAccount() {
        setType("PrivateAccount");
    }

    @Override
    public void speak() {
        System.out.println("개인계좌");
    }

    @Override
    public void run() {
        System.out.println(" privateaccount Run!!!");
        
    }

    @Override
    public void eat() {
        
        setEnergy(getEnergy() + 2);

    }

    @Override
    public void sleep() {
        super.sleep();
      
        setAppearance(getAppearance() + 1);
        
    }

    
    
    
}
