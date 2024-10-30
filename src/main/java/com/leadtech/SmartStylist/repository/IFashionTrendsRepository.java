package com.leadtech.SmartStylist.repository;

import com.leadtech.SmartStylist.model.FashionTrends;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IFashionTrendsRepository extends MongoRepository<FashionTrends, String> {
}
