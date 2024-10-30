package com.leadtech.SmartStylist.model;

import com.leadtech.SmartStylist.model.components.Endereco;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "purchase_history")
public class PurchaseHistory {

    @Id
    @BsonId
    @Field("_id")
    private String id;;

    @Field("client_id")
    private String clientId;

    @Field("product_ids")
    private List<String> productIds;

    @Field("data_compra")
    private Date dataCompra;

    @Field("total")
    private double total;

    @Field("metodo_pagamento")
    private String metodoPagamento;

    @Field("status")
    private String status;

    @Field("endereco_entrega")
    private Endereco enderecoEntrega;

    @Field("desconto")
    private double desconto;

    @Field("nota_cliente")
    private double notaCliente;

    @Field("data_entrega")
    private Date dataEntrega;

}
