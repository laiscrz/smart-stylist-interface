package com.leadtech.SmartStylist.model.components;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Endereco {
    private String rua;
    private String cidade;
    private String estado;
    private String pais;

}