package ru.vsu.cs.javaweb.dto;

import lombok.Data;
import ru.vsu.cs.javaweb.entity.Account;

@Data
public class OperationDto {
    private Integer summ;

    private Boolean operationType;

    private String currency;

    private Account account;
}
