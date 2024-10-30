package com.leadtech.SmartStylist.repository;

import com.leadtech.SmartStylist.model.FashionTrends;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFashionTrendsRepository extends MongoRepository<FashionTrends, String> {
}
