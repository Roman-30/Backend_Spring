package ru.vsu.cs.javaweb.dto;

import lombok.Data;

@Data
public class ClientDto {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String phone;
    private String email;
    private String passport;
}
