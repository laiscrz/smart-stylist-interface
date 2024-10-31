package com.leadtech.SmartStylist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leadtech.SmartStylist.model.components.ExperienciaInterativa;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "virtual_try_on")
public class VirtualTryOn {

    @Id
    @BsonId
    @Field("_id")
    private String id;

    @Field("client_id")
    private String clientId;

    @Field("products_experimentados")
    private List<String> productsExperimentados;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Field("data_experimento")
    private Date dataExperimento;

    @Field("resultado")
    private String resultado;

    @Field("observacoes")
    private String observacoes;

    @Field("experiencia_interativa")
    private ExperienciaInterativa experienciaInterativa;

    @Field("recomendacao")
    private String recomendacao;

    @Field("nivel_acuracia")
    private String nivelAcuracia;

    @Field("status_tentativa")
    private String statusTentativa;

}
