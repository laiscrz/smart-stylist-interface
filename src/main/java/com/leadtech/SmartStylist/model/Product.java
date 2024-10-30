package com.leadtech.SmartStylist.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "product")
public class Product {

    @Id
    @BsonId
    @Field("_id")
    private String id;

    private String nome;

    private String categoria;

    private Double preco;

    private Integer estoque;

    @Field("tamanhos_disponiveis")
    private List<String> tamanhosDisponiveis;

    @Field("cores_disponiveis")
    private List<String> coresDisponiveis;

    @Field("data_adicao")
    private Date dataAdicao;

    private String sazonalidade;

    @Field("imagem_url")
    private String imagemUrl;

    private String marca;

    private String padrao;
}
