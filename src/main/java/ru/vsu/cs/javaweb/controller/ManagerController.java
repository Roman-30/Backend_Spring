package ru.vsu.cs.javaweb.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.javaweb.dto.ManagerDto;
import ru.vsu.cs.javaweb.service.ManagerService;

import java.util.List;

@RestController
public class ManagerController {
    private final ManagerService service;

    public ManagerController(ManagerService service) {
        this.service = service;
    }

    @PostMapping("/manager/new")
    public void addNewManager(@RequestBody ManagerDto manager) {
        service.saveNew(manager);
    }

    @GetMapping("/managers")
    public List<ManagerDto> getAllManagers() {
        return service.getAll();
    }

    @PutMapping("/manager/update/{id}")
    public void updateManager(@PathVariable Integer id, @RequestBody ManagerDto managerDto) {
        service.updateManager(id, managerDto);
    }

    @DeleteMapping("/manager/delete/{id}")
    public void deleteManager(@PathVariable Integer id) {
        service.deleteManager(id);
    }
}
