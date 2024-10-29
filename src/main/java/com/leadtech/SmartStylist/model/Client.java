package com.leadtech.SmartStylist.model;

import com.leadtech.SmartStylist.model.components.Endereco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
@Document(collection = "client")
public class Client {

    @Id
    @BsonId
    @Field("_id")
    private String id; // Correspondente ao "_id" do MongoDB

    private String nome;
    private String email;

    @Field("preferencias_estilo")
    private List<String> preferenciasEstilo;
    @Field("data_cadastro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataCadastro;
    private int idade;
    private String genero;
    private String telefone;
    private Endereco endereco;


}
