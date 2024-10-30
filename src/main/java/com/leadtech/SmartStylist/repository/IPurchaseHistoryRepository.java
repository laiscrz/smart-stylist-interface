package com.leadtech.SmartStylist.repository;

import com.leadtech.SmartStylist.model.PurchaseHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPurchaseHistoryRepository extends MongoRepository<PurchaseHistory, String> {
}
