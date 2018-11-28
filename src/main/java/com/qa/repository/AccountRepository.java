package com.qa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.domain.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{

}
