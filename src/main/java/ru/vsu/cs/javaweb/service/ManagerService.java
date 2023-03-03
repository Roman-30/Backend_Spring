package ru.vsu.cs.javaweb.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.javaweb.dto.ManagerDto;
import ru.vsu.cs.javaweb.entity.Manager;
import ru.vsu.cs.javaweb.mapper.ManagerMapper;
import ru.vsu.cs.javaweb.repository.ManagerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerService {
    private final ManagerRepository repository;
    private final ManagerMapper mapper;

    public ManagerService(ManagerRepository repository, ManagerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void saveNew(ManagerDto client) {
        repository.save(mapper.toEntity(client));
    }

    public List<ManagerDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteManager(Integer id) {
        repository.delete(repository.findManagerById(id));
    }

    public void updateManager(Integer id, ManagerDto client) {
        Manager oldManager = repository.findManagerById(id);
        Manager managerNew = mapper.toEntity(client);
        managerNew.setId(oldManager.getId());
        repository.save(managerNew);
    }
}
