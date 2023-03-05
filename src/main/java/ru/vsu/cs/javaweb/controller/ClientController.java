package ru.vsu.cs.javaweb.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.javaweb.dto.ClientDto;
import ru.vsu.cs.javaweb.service.ClientService;

import java.util.List;

@RestController
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/clients")
    public List<ClientDto> getAllClients() {
        return service.getAll();
    }
    @PostMapping("/client/new")
    public void saveNewClient(@RequestBody ClientDto client) {
        service.saveNew(client);
    }
    @PutMapping("/client/update/{id}")
    public void updateClient(@PathVariable Integer id, @RequestBody ClientDto clientDto) {
        service.updateClient(id, clientDto);
    }
    @DeleteMapping("/client/delete/{id}")
    public void deleteClient(@PathVariable Integer id) {
        service.deleteClient(id);
    }
}
