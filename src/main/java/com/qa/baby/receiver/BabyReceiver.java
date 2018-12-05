package com.qa.baby.receiver;

import com.qa.baby.persistence.domain.JumperBaby;
import com.qa.baby.persistence.repository.MongoBabyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BabyReceiver {

    @Autowired
    private MongoBabyRepo repo;

    @JmsListener(destination = "BabyQueue", containerFactory = "myFactory")
    public void receiveMessage(JumperBaby baby){
        System.out.println("recieved baby: " + baby);
        System.out.println(repo.save(baby));
    }

    @JmsListener(destination = "BabyQueueDelete", containerFactory = "myFactory")
    public void receiveDelete(JumperBaby baby){
        System.out.println("ID: " + baby.getId());
        Optional<JumperBaby> lookBaby = repo.findById(Long.parseLong(baby.getId()));
        System.out.println("lookbaby present: " + lookBaby.isPresent());
        System.out.println(repo.findAll());
//        System.out.println(repo.findById(baby.getId()).get());
//        repo.deleteById(baby.getId());
    }

}
