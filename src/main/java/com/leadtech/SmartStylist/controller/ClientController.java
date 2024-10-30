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


}
