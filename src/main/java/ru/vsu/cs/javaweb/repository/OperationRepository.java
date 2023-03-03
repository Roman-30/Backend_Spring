package ru.vsu.cs.javaweb.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.javaweb.entity.Operation;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Integer> {
    @NonNull List<Operation> findAll();
    @Query("SELECT o FROM Operation o WHERE o.id = :id")
    Operation findOperationById(Integer id);


}
