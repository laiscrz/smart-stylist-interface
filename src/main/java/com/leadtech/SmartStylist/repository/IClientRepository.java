package com.leadtech.SmartStylist.repository;

import com.leadtech.SmartStylist.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientRepository extends MongoRepository<Client, String> {
    // Consulta para encontrar clientes pelo nome
    @Query("{ 'nome': { $regex: ?0, $options: 'i' } }")
    List<Client> findByNome(String nome);

    // Consulta para encontrar clientes por idade
    @Query("{ 'idade': { $gte: ?0, $lte: ?1 } }")
    List<Client> findByIdadeBetween(int idadeMin, int idadeMax);
}
