package com.leadtech.SmartStylist.repository;

import com.leadtech.SmartStylist.model.Lookbook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILookbookRepository extends MongoRepository<Lookbook, String> {
}
