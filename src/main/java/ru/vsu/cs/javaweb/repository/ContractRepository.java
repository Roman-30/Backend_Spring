package ru.vsu.cs.javaweb.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.javaweb.entity.Client;
import ru.vsu.cs.javaweb.entity.Contract;
import ru.vsu.cs.javaweb.entity.Manager;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {
    @NonNull List<Contract> findAll();

    @Query("SELECT c FROM Client c WHERE c.passport = :passport")
    Client findClient(String passport);

    @Query("SELECT m FROM Manager m WHERE m.passport = :passport")
    Manager findManager(String passport);

    @Query("SELECT c FROM Contract c WHERE c.id = :id")
    Contract findContractById(Integer id);
}
