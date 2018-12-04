package com.qa.BabyConsumer.receiver;

import com.qa.BabyConsumer.persistence.domain.Baby;
import com.qa.BabyConsumer.persistence.repository.MongoBabyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BabyReceiver {

    @Autowired
    private MongoBabyRepo repo;

    @JmsListener(destination = "BabyQueue", containerFactory = "myFactory")
    public void receiveMessage(Baby baby){
        repo.save(baby);
    }

}
