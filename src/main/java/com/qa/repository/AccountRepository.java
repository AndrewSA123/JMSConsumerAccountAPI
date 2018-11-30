package com.qa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.domain.ATP;

@Repository
public interface AccountRepository extends MongoRepository<ATP, String> {

}
