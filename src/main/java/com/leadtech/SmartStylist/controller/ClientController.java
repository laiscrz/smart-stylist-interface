package com.leadtech.SmartStylist.controller;

import com.leadtech.SmartStylist.model.Client;
import com.leadtech.SmartStylist.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String viewClientsPage(@RequestParam(required = false) String nome,
                                  @RequestParam(required = false) Integer idadeMin,
                                  @RequestParam(required = false) Integer idadeMax,
                                  Model model) {
        List<Client> clients;

        if (nome != null && !nome.isEmpty()) {
            clients = clientService.getClientsByName(nome);
        } else if (idadeMin != null && idadeMax != null) {
            clients = clientService.getClientsByAge(idadeMin, idadeMax);
        } else {
            clients = clientService.findAll();
        }

        model.addAttribute("clients", clients);
        return "client/list";
    }

    @GetMapping("/details/{id}")
    public String viewClientDetailsPage(@PathVariable String id, Model model) {
        Client client = clientService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID: " + id));
        model.addAttribute("client", client);
        return "client/details"; 
    }

    // Método para exibir o formulário de criação/edição de cliente
    @GetMapping("/new")
    public String showClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditClientForm(@PathVariable String id, Model model) {
        Client client = clientService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID: " + id));
        model.addAttribute("client", client);
        return "client/form";
    }

    @PostMapping("/create")
    public String createClient(@ModelAttribute("client") Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable String id, @ModelAttribute("client") Client client) {
        if (clientService.findById(id).isPresent()) {
            client.setId(id);
            clientService.update(id, client);
        }
        return "redirect:/clients";
    }


    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable String id, Model model) {
        if (clientService.findById(id).isEmpty()) {
            return "redirect:/clients";
        }
        clientService.deleteById(id);
        return "redirect:/clients";
    }


}
