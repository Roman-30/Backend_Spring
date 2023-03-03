package ru.vsu.cs.javaweb.dto;

import lombok.Data;

@Data
public class ManagerDto {
    private String first_name;
    private String last_name;
    private String patronymic;
    private String email;
    private String passport;

}
