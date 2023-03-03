package ru.vsu.cs.javaweb.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.javaweb.dto.ContractDto;
import ru.vsu.cs.javaweb.dto.SimpleClient;
import ru.vsu.cs.javaweb.dto.SimpleContract;
import ru.vsu.cs.javaweb.dto.SimpleManager;
import ru.vsu.cs.javaweb.entity.Client;
import ru.vsu.cs.javaweb.entity.Contract;
import ru.vsu.cs.javaweb.entity.Manager;
import ru.vsu.cs.javaweb.mapper.ContractMapper;
import ru.vsu.cs.javaweb.repository.ContractRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContractService {
    private final ContractMapper mapper;
    private final ContractRepository repository;

    public ContractService(ContractMapper mapper, ContractRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public void saveNew(SimpleContract contract) {
        repository.save(createContract(contract.getSClient(), contract.getSimpleManager()));
    }

    public void saveNew(Contract contract) {
        repository.save(contract);
    }

    private Contract createContract(SimpleClient sc, SimpleManager sm) {
        Client client = repository.findClient(sc.getPassport());
        Manager manager = repository.findManager(sm.getPassport());
        Contract contract = new Contract();
        contract.setClient(client);
        contract.setManager(manager);
        return contract;
    }

    public List<ContractDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    private Contract findById(Integer id) {
        Optional<Contract> optionalContract = repository.findAll()
                .stream().filter(val -> val.getId().equals(id))
                .findFirst();
        return optionalContract.orElseGet(optionalContract::orElseThrow);
    }

    public void deleteContract(Integer id) {
        repository.delete(repository.findContractById(id));
    }
}
