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

    public String formatEndereco(Endereco endereco) {
        return String.format("%s, %s, %s, %s", endereco.getRua(), endereco.getCidade(), endereco.getEstado(), endereco.getPais());
    }

}