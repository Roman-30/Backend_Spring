package ru.vsu.cs.javaweb.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.javaweb.entity.Account;
import ru.vsu.cs.javaweb.entity.Contract;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @NonNull List<Account> findAll();

    @Query("SELECT c FROM Contract c WHERE c.id = :id")
    Contract findContractById(Integer id);

    @Query("SELECT a FROM Account a WHERE a.id = :id")
    Account findAccountById(Integer id);

}
