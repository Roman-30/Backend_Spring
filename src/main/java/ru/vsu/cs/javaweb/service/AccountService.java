package ru.vsu.cs.javaweb.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.javaweb.dto.AccountDto;
import ru.vsu.cs.javaweb.entity.Account;
import ru.vsu.cs.javaweb.entity.Contract;
import ru.vsu.cs.javaweb.mapper.AccountMapper;
import ru.vsu.cs.javaweb.repository.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository repository;
    private final AccountMapper mapper;

    public AccountService(AccountRepository repository, AccountMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void saveNew(AccountDto account) {
        Account newAccount = new Account();
        Contract contract = repository.findContractById(account.getId());
        newAccount.setContract(contract);
        newAccount.setSum(0);
        repository.save(newAccount);
    }

    public List<AccountDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }
    public void deleteAccount(Integer id) {
        repository.delete(repository.findAccountById(id));
    }
}
