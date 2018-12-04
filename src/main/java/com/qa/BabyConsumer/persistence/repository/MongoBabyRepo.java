package com.qa.BabyConsumer.persistence.repository;

import com.qa.BabyConsumer.persistence.domain.Baby;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoBabyRepo extends MongoRepository<Baby, Long> {
}
