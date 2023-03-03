package ru.vsu.cs.javaweb.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.javaweb.dto.ClientDto;
import ru.vsu.cs.javaweb.entity.Client;
import ru.vsu.cs.javaweb.mapper.ClientMapper;
import ru.vsu.cs.javaweb.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientService(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void deleteClient(Integer id) {
        repository.delete(repository.findClientById(id));
    }

    public void updateClient(Integer id, ClientDto client) {
        Client oldClient = repository.findClientById(id);
        Client clientNew = mapper.toEntity(client);
        clientNew.setId(oldClient.getId());
        repository.save(clientNew);
    }
    public void saveNew(ClientDto client) {
        repository.save(mapper.toEntity(client));
    }

    public List<ClientDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
