package ru.vsu.cs.javaweb.dto;

import lombok.Data;

@Data
public class SimpleContract {
     private SimpleClient sClient;
     private SimpleManager simpleManager;
}
