package com.leadtech.SmartStylist.controller;

import com.leadtech.SmartStylist.model.Client;
import com.leadtech.SmartStylist.service.ClientService;
import com.leadtech.SmartStylist.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ExportService exportService;

    @GetMapping
    @ResponseBody
    public List<Client> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = clientService.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody Client client) {
        try {
            Client updatedClient = clientService.update(id, client);
            return ResponseEntity.ok(updatedClient);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable String id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Exportação em JSON
    @GetMapping("/export/json")
    public ResponseEntity<List<Client>> exportClientsAsJson() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=clients.json")
                .contentType(MediaType.APPLICATION_JSON)
                .body(clients);
    }

    // Exportação em CSV usando o ExportService
    @GetMapping("/export/csv")
    public ResponseEntity<byte[]> exportClientsAsCsv() {
        List<Client> clients = clientService.findAll();
        byte[] csvData = exportService.exportClientsToCsv(clients);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=clients.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(csvData);
    }
}
