package ru.vsu.cs.javaweb.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.javaweb.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @NonNull List<Client> findAll();
    @NonNull List<Client> findAllById(@NonNull Iterable<Integer> ids);

    @Query("SELECT c FROM Client c WHERE c.id = :id")
    Client findClientById(Integer id);
}
