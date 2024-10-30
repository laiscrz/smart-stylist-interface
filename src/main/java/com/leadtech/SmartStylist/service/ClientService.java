package com.leadtech.SmartStylist.service;

import com.leadtech.SmartStylist.model.Client;
import com.leadtech.SmartStylist.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private IdGeneratorService idGeneratorService;

    @Autowired
    private IClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    public void save(Client client) {
        // Somente gerar um novo ID se o cliente ainda não tiver um ID definido
        if (client.getId() == null || client.getId().isEmpty()) {
            String id = idGeneratorService.generateId("C", "client");
            client.setId(id);
        }
        clientRepository.save(client);
    }

    public void update(String id, Client client) {
        // Verifica se o cliente existe
        if (!clientRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado com id: " + id);
        }
        client.setId(id);
        clientRepository.save(client);
    }

    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }
}
