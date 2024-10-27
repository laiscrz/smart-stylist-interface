package com.leadtech.SmartStylist.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

@Service
public class IdGeneratorService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String generateId(String prefix, String collectionName) {
        // Cria a agregação para encontrar o maior ID com o prefixo desejado
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("_id").regex("^" + prefix + "\\d+$")),
                Aggregation.project()
                        .andExpression("toInt(substr(_id, " + prefix.length() + ", -1))").as("numericId"),
                Aggregation.group()
                        .max("numericId").as("maxId")
        );

        // Executa a agregação
        AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, collectionName, Document.class);

        int nextId = 1;
        if (!results.getMappedResults().isEmpty()) {
            // Acessa o valor máximo diretamente do Document
            Document maxIdResult = results.getMappedResults().get(0);
            nextId = maxIdResult.getInteger("maxId") + 1; // Incrementa o máximo encontrado
        }

        // Retorna o novo ID formatado com o prefixo
        return prefix + nextId;
    }
}
