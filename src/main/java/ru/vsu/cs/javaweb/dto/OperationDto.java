package ru.vsu.cs.javaweb.dto;

import lombok.Data;

@Data
public class OperationDto {
    private Integer summ;

    private Boolean operationType;

    private String currency;

    private AccountDto account;
}
