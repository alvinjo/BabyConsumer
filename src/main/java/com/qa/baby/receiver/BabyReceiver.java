package com.qa.baby.receiver;

import com.qa.baby.persistence.domain.JumperBaby;
import com.qa.baby.persistence.repository.MongoBabyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BabyReceiver {

    @Autowired
    private MongoBabyRepo repo;

    @JmsListener(destination = "BabyQueue", containerFactory = "myFactory")
    public void receiveMessage(JumperBaby baby){
        System.out.println(repo.save(baby));
    }

    @JmsListener(destination = "BabyQueueDelete", containerFactory = "myFactory")
    public void receiveDelete(JumperBaby baby){
        System.out.println(baby);
        repo.deleteById(baby.getId());
    }

}
