package ru.nau.calcProjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nau.calcProjects.exception.ClientExistException;
import ru.nau.calcProjects.exception.ClientNotFoundException;
import ru.nau.calcProjects.exception.PriceNotFoundException;
import ru.nau.calcProjects.models.Client;
import ru.nau.calcProjects.models.Price;
import ru.nau.calcProjects.services.ClientService;

import java.util.List;

@RestController
public class ClientRestController {

    private final ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/api/client")
    public List<Client> getAllPrices() {
        return clientService.findAll();
    }

    @GetMapping ("/api/client/{id}")
    public Client getPrice(@PathVariable long id) throws ClientNotFoundException {
        return clientService.getById(id);
    }

    @PostMapping("/api/client")
    public Client createPrice(@RequestBody Client client) throws ClientExistException {
        if (client.getTitle().isEmpty()) {
            throw new RuntimeException("Название клиента не может быть пустым. Необходимо заполнить.");
        }
        return clientService.createClient(client);
    }

    @PutMapping("/api/client/{id}")
    public Client editPrice(@PathVariable("id") long id, @RequestBody Client client) throws ClientNotFoundException {
        if (client.getTitle().isEmpty()) {
            throw new RuntimeException("Название прайса не может быть пустым. Необходимо заполнить.");
        }
        return clientService.editClient(client, id);
    }

    @DeleteMapping("/api/client/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        clientService.deleteById(id);
        return "{\"state\":\"success\"}";
    }
}
