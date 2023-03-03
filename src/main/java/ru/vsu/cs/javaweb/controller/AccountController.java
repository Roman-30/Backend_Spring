package ru.vsu.cs.javaweb.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.javaweb.dto.AccountDto;
import ru.vsu.cs.javaweb.service.AccountService;

import java.util.List;

@RestController
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/accounts")
    public List<AccountDto> getAllAccounts() {
        return service.getAll();
    }


    @PostMapping("/account/new")
    public void saveNew(@RequestBody AccountDto account) {
        service.saveNew(account);
    }

//    @DeleteMapping("/account/delete/{id}")
//    public void deleteAccount(@PathVariable Integer id) {
//        service.deleteAccount(id);
//    }
}
