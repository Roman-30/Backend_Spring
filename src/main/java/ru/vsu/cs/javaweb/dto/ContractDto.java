package ru.vsu.cs.javaweb.dto;

import lombok.Data;

@Data
public class ContractDto {
    private ClientDto client;

    private ManagerDto manager;
}
