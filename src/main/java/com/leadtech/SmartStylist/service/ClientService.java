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
        String id = idGeneratorService.generateId("C", "client");
        client.setId(id);
        return clientRepository.save(client);
    }

    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }
}
