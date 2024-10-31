package com.leadtech.SmartStylist.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "fashion_trends")
public class FashionTrends {

    @Id
    @BsonId
    @Field("_id")
    private String id;

    private String nome;

    private String descricao;

    private int popularidade;

    private String sazonalidade;

    private String categoria;

    private boolean tendencia;


    @Field("custo_medio")
    private double custoMedio;

    private String origem;

    private List<String> materiais;

    private String estilo;

    private String fonte;
}
