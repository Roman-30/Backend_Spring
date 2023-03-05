package ru.vsu.cs.javaweb.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.javaweb.dto.OperationDto;
import ru.vsu.cs.javaweb.service.OperationService;

import java.util.List;

@RestController
public class OperationController {
    private final OperationService service;

    public OperationController(OperationService service) {
        this.service = service;
    }

    @PostMapping("/operation/new")
    public void addNewOperation(@RequestBody OperationDto operation) {
        System.out.println(operation);
        service.saveNew(operation);
    }

    @GetMapping("/operations")
    public List<OperationDto> getAllOperations() {
        return service.getAll();
    }

    @DeleteMapping("/operation/delete/{id}")
    public void deleteOperation(@PathVariable Integer id) {
        service.deleteOperation(id);
    }
}
