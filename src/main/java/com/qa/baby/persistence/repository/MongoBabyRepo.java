package com.qa.baby.persistence.repository;

import com.qa.baby.persistence.domain.JumperBaby;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoBabyRepo extends MongoRepository<JumperBaby, Long> {
}
