package com.leadtech.SmartStylist.controller;

import com.leadtech.SmartStylist.model.Client;
import com.leadtech.SmartStylist.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    @ResponseBody // Adicionado para retornar a lista como JSON
    public List<Client> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody // Adicionado para retornar o cliente como JSON
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        return clientService.findById(id)
                .map(client -> ResponseEntity.ok(client))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseBody // Adicionado para retornar o cliente criado como JSON
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = clientService.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @PutMapping("/{id}")
    @ResponseBody // Adicionado para retornar o cliente atualizado como JSON
    public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody Client client) {
        client.setId(id); // Define o ID do cliente para garantir que estamos atualizando o correto
        Client updatedClient = clientService.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable String id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
