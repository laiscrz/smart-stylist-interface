package com.leadtech.SmartStylist.repository;

import com.leadtech.SmartStylist.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends MongoRepository<Client, String> {

}
