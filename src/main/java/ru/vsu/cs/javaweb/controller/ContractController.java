package ru.vsu.cs.javaweb.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.javaweb.dto.ContractDto;
import ru.vsu.cs.javaweb.dto.SimpleContract;
import ru.vsu.cs.javaweb.entity.Contract;
import ru.vsu.cs.javaweb.service.ContractService;

import java.util.List;

@RestController
public class ContractController {
    private final ContractService service;

    public ContractController(ContractService service) {
        this.service = service;
    }

    @PostMapping("/contract/new/pass")
    public void addNewOperationByPass(@RequestBody SimpleContract contract) {
        service.saveNew(contract);
    }

    @PostMapping("/contract/new")
    public void addNewOperation(@RequestBody Contract contract) {
        service.saveNew(contract);
    }
    @GetMapping("/contracts")
    public List<ContractDto> getAllContracts() {
        return service.getAll();
    }

    @DeleteMapping("/contract/delete/{id}")
    public void deleteContract(@PathVariable Integer id) {
        service.deleteContract(id);
    }
}


