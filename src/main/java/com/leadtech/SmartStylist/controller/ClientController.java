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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ExportService exportService;

    @GetMapping("/list")
    public String viewClientsPage(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "client/list";
    }

    @GetMapping("/details/{id}")
    public String viewClientDetailsPage(@PathVariable String id, Model model) {
        Client client = clientService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID: " + id));
        model.addAttribute("client", client);
        return "client/details"; // Nome da nova view
    }

    // Método para exibir o formulário de criação/edição de cliente
    @GetMapping("/new")
    public String showClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/form"; // Nome do arquivo HTML do formulário
    }

    @GetMapping("/edit/{id}")
    public String showEditClientForm(@PathVariable String id, Model model) {
        Client client = clientService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID: " + id));
        model.addAttribute("client", client);
        return "client/form"; // O mesmo formulário é usado para edição
    }

    @PostMapping("/{id}")
    public String saveClient(@ModelAttribute("client") Client client) {
        if (client.getId() != null) {
            clientService.update(client.getId(), client);
        } else {
            clientService.save(client);
        }
        return "redirect:/clients/list"; // Redireciona para a lista após salvar
    }





    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable String id, Model model) {
        if (clientService.findById(id).isEmpty()) { // Verifica se o cliente não existe
            return "redirect:/clients/list"; // Redireciona para a lista se o cliente não existir
        }
        clientService.deleteById(id); // Exclui o cliente
        return "redirect:/clients/list"; // Redireciona para a lista após a exclusão
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
