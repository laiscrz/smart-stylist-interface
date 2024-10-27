package com.leadtech.SmartStylist.service;

import com.leadtech.SmartStylist.model.Client;
import com.leadtech.SmartStylist.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private IdGeneratorService idGeneratorService;

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    public Client save(Client client) {
        // Somente gerar um novo ID se o cliente ainda não tiver um ID definido
        if (client.getId() == null || client.getId().isEmpty()) {
            String id = idGeneratorService.generateId("C", "client");
            client.setId(id);
        }
        return clientRepository.save(client);
    }

    public Client update(String id, Client client) {
        // Verifica se o cliente existe
        if (!clientRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado com id: " + id);
        }
        client.setId(id); // Certifica-se de que o ID fornecido é usado para a atualização
        return clientRepository.save(client);
    }

    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }
}
