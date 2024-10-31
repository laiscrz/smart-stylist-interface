package com.leadtech.SmartStylist.repository;

import com.leadtech.SmartStylist.model.VirtualTryOn;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IVirtualTryOnRepository extends MongoRepository<VirtualTryOn, String> {
}
