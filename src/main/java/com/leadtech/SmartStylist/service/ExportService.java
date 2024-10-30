package com.leadtech.SmartStylist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.leadtech.SmartStylist.model.*;
import com.leadtech.SmartStylist.model.components.Endereco;
import com.leadtech.SmartStylist.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

@Service
public class ExportService {

    @Autowired
    private IClientRepository clientRepository;
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IFashionTrendsRepository fashionTrendsRepository;

    @Autowired
    private ILookbookRepository lookbookRepository;

    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;

    private final Endereco enderecoFormatter = new Endereco();


    public void exportClients(OutputStream outputStream, String format) throws IOException {
        List<Client> clients = clientRepository.findAll();
        if ("csv".equalsIgnoreCase(format)) {
            // Lógica para exportar como CSV
            PrintWriter writer = new PrintWriter(outputStream);
            writer.write("\uFEFF"); // BOM para UTF-8s
            writer.println("id;nome;email;preferencias_estilo;data_cadastro;idade;genero;telefone;endereco");

            for (Client client : clients) {
                writer.printf("%s;%s;%s;\"%s\";%s;%d;%s;%s;%s%n",
                        client.getId(),
                        client.getNome(),
                        client.getEmail(),
                        String.join(",", client.getPreferenciasEstilo()),
                        client.getDataCadastro() != null ? client.getDataCadastro() : "",
                        client.getIdade(),
                        client.getGenero(),
                        client.getTelefone(),
                        client.getEndereco() != null ? enderecoFormatter.formatEndereco(client.getEndereco()) : "");;
            }
            writer.flush();
        } else if ("json".equalsIgnoreCase(format)) {
            // Lógica para exportar como JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(outputStream, clients);
        }
    }

    public void exportProducts(OutputStream outputStream, String format) throws IOException {
        List<Product> products = productRepository.findAll();
        if ("csv".equalsIgnoreCase(format)) {
            // Lógica para exportar como CSV
            PrintWriter writer = new PrintWriter(outputStream);
            writer.write("\uFEFF"); // BOM para UTF-8
            writer.println("id;nome;categoria;preco;estoque;tamanhos_disponiveis;cores_disponiveis;data_adicao;sazonalidade;imagem_url;marca;padrao");
            for (Product product : products) {
                writer.printf("%s;%s;%s;%.2f;%d;%s;%s;%s;%s;%s;%s;%s%n",
                        product.getId(),
                        product.getNome(),
                        product.getCategoria(),
                        product.getPreco(),
                        product.getEstoque(),
                        product.getTamanhosDisponiveis() != null ? String.join(",", product.getTamanhosDisponiveis()) : "",
                        product.getCoresDisponiveis() != null ? String.join(",", product.getCoresDisponiveis()) : "",
                        product.getDataAdicao(),
                        product.getSazonalidade(),
                        product.getImagemUrl(),
                        product.getMarca(),
                        product.getPadrao());
            }
            writer.flush();
        } else if ("json".equalsIgnoreCase(format)) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(outputStream, products);
        }
    }

    public void exportFashionTrends(OutputStream outputStream, String format) throws IOException {
        List<FashionTrends> fashionTrends = fashionTrendsRepository.findAll();
        if ("csv".equalsIgnoreCase(format)) {
            // Lógica para exportar como CSV
            PrintWriter writer = new PrintWriter(outputStream);
            writer.write("\uFEFF"); // BOM para UTF-8
            writer.println("id;nome;descricao;popularidade;sazonalidade;categoria;tendencia;custo_medio;origem;materiais;estilo;fonte");

            for (FashionTrends trend : fashionTrends) {
                writer.printf("%s;%s;%s;%d;%s;%s;%b;%.2f;%s;%s;%s;%s%n",
                        trend.getId(),
                        trend.getNome(),
                        trend.getDescricao(),
                        trend.getPopularidade(),
                        trend.getSazonalidade(),
                        trend.getCategoria(),
                        trend.isTendencia(),
                        trend.getCustoMedio(),
                        trend.getOrigem(),
                        String.join(",", trend.getMateriais()),
                        trend.getEstilo(),
                        trend.getFonte());
            }
            writer.flush();
        } else if ("json".equalsIgnoreCase(format)) {
            // Lógica para exportar como JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(outputStream, fashionTrends);
        }
    }

    public void exportLookbook(OutputStream outputStream, String format) throws IOException {
        List<Lookbook> lookbooks = lookbookRepository.findAll();
        if ("csv".equalsIgnoreCase(format)) {
            // Lógica para exportar como CSV
            PrintWriter writer = new PrintWriter(outputStream);
            writer.write("\uFEFF"); // BOM para UTF-8
            writer.println("id;nome;descricao;client_id;data_criacao;categoria;estilo;preco_total;avaliacao;product_ids");

            for (Lookbook lookbook : lookbooks) {
                writer.printf("%s;%s;%s;%s;%s;%s;%s;%.2f;%.2f;%s%n",
                        lookbook.getId(),
                        lookbook.getNome(),
                        lookbook.getDescricao(),
                        lookbook.getClientId(),
                        lookbook.getDataCriacao() != null ? lookbook.getDataCriacao() : "",
                        lookbook.getCategoria(),
                        lookbook.getEstilo(),
                        lookbook.getPrecoTotal(),
                        lookbook.getAvaliacao(),
                        lookbook.getProductIds() != null ? String.join(",", lookbook.getProductIds()) : ""); // Converte a lista para uma string separada por vírgulas
            }
            writer.flush();
        } else if ("json".equalsIgnoreCase(format)) {
            // Lógica para exportar como JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(outputStream, lookbooks);
        }
    }



    public void exportPurchaseHistory(OutputStream outputStream, String format) throws IOException {
        List<PurchaseHistory> purchaseHistories = purchaseHistoryRepository.findAll();
        if ("csv".equalsIgnoreCase(format)) {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.write("\uFEFF"); // BOM for UTF-8
            writer.println("id;client_id;product_ids;data_compra;total;metodo_pagamento;status;endereco_entrega;desconto;nota_cliente;data_entrega");

            for (PurchaseHistory history : purchaseHistories) {
                writer.printf("%s;%s;%s;%s;%.2f;%s;%s;%s;%s;%.1f;%s%n",
                        history.getId(),
                        history.getClientId(),
                        String.join(",", history.getProductIds()),
                        history.getDataCompra() != null ? history.getDataCompra().toString() : "",
                        history.getTotal(),
                        history.getMetodoPagamento(),
                        history.getStatus(),
                        enderecoFormatter.formatEndereco(history.getEnderecoEntrega()),
                        history.getDesconto(),
                        history.getNotaCliente(),
                        history.getDataEntrega() != null ? history.getDataEntrega().toString() : "");
            }
            writer.flush();
        } else if ("json".equalsIgnoreCase(format)) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(outputStream, purchaseHistories);
        }
    }


}
