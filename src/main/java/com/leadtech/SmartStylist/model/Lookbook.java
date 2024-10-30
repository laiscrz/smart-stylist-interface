package com.leadtech.SmartStylist.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "lookbook")
public class Lookbook {

    @Id
    @BsonId
    @Field("_id")
    private String id;

    private String nome;
    private String descricao;
    @Field("client_id")
    private String clientId;
    @Field("product_ids")
    private List<String> productIds;

    @Field("data_criacao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataCriacao;
    private String categoria;
    private String estilo;
    @Field("preco_total")
    private Double precoTotal;
    private Double avaliacao;
}

