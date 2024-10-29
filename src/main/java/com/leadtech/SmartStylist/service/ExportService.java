package com.leadtech.SmartStylist.service;

import com.leadtech.SmartStylist.model.Client;
import com.leadtech.SmartStylist.model.components.Endereco;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ExportService {

    public byte[] exportClientsToCsv(List<Client> clients) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(out);

        // Definindo o formato da data
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Cabeçalho do CSV
        writer.println("ID;Nome;Email;PreferenciasEstilo;DataCadastro;Idade;Genero;Telefone;Endereco");

        // Dados do CSV
        clients.forEach(client -> {
            String enderecoFormatado = formatEndereco(client.getEndereco());
            writer.println(
                    client.getId() + ";" +
                            client.getNome() + ";" +
                            client.getEmail() + ";" +
                            String.join(",", client.getPreferenciasEstilo()) + ";" +
                            dateFormat.format(client.getDataCadastro()) + ";" +
                            client.getIdade() + ";" +
                            client.getGenero() + ";" +
                            client.getTelefone() + ";" +
                            enderecoFormatado
            );

            // Log para depuração
            System.out.println("Exportando cliente: " + client.getNome() + ", Endereço: " + enderecoFormatado);
        });

        writer.flush();
        return out.toByteArray();
    }


    // Método auxiliar para formatar o endereço no CSV
    private String formatEndereco(Endereco endereco) {
        if (endereco == null) return "";
        return endereco.getRua() + " " +
                endereco.getCidade() + ", " +
                endereco.getEstado() + "," +
                endereco.getPais();
    }
}
