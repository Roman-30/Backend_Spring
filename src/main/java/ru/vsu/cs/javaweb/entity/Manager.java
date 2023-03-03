package ru.vsu.cs.javaweb.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String first_name;
    @NonNull
    private String last_name;
    @NonNull
    private String patronymic;
    @NonNull
    private String email;
    @NonNull
    private String passport;
}
