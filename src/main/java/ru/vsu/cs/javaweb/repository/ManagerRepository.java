package ru.vsu.cs.javaweb.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.javaweb.entity.Manager;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    @NonNull List<Manager> findAll();

    @Query("SELECT m FROM Manager m WHERE m.id = :id")
    Manager findManagerById(Integer id);
}
