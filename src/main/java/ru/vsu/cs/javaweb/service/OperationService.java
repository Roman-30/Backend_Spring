package ru.vsu.cs.javaweb.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.vsu.cs.javaweb.dto.OperationDto;
import ru.vsu.cs.javaweb.entity.Account;
import ru.vsu.cs.javaweb.entity.Operation;
import ru.vsu.cs.javaweb.entity.models.Currency;
import ru.vsu.cs.javaweb.mapper.OperationMapper;
import ru.vsu.cs.javaweb.repository.AccountRepository;
import ru.vsu.cs.javaweb.repository.OperationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperationService {
    private final OperationMapper mapper;
    private final OperationRepository operRepository;
    private final AccountRepository accRepository;

    public OperationService(OperationMapper mapper, OperationRepository operRepository, AccountRepository accRepository) {
        this.mapper = mapper;
        this.operRepository = operRepository;
        this.accRepository = accRepository;
    }

    public void saveNew(OperationDto dto) {
        Account account = accRepository.findAccountById(dto.getAccount().getId());
        Operation operation = mapper.toEntity(dto);
        updateSum(operation);
        operation.setAccount(account);
        operRepository.save(operation);
    }

    private void updateSum(@NonNull Operation operation) {

        Account account = accRepository.findAccountById(operation.getAccount().getId());
        Integer rate = getRate(operation.getCurrency());
        Integer oldSum = account.getSum();
        if (operation.getOperationType()) {
            oldSum += (operation.getSumm() * rate);
        } else {
            oldSum -= (operation.getSumm() * rate);

            if (oldSum < 0) return;
        }
        account.setSum(oldSum);
        accRepository.save(account);
    }

    private Integer getRate(String currency) {
        if (Currency.CURRENCY.containsKey(currency)) {
            return Currency.CURRENCY.get(currency);
        }
        return null;
    }

    public List<OperationDto> getAll() {
        return operRepository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    private Operation findById(Integer id) {
        Optional<Operation> optionalManager = operRepository.findAll()
                .stream().filter(val -> val.getId().equals(id))
                .findFirst();
        return optionalManager.orElseGet(optionalManager::orElseThrow);
    }

    public void deleteOperation(Integer id) {
        operRepository.delete(operRepository.findOperationById(id));
    }
}
