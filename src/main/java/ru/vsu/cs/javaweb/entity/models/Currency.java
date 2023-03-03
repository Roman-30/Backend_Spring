package ru.vsu.cs.javaweb.entity.models;

import java.util.HashMap;

public class Currency {
    public static final HashMap<String, Integer> CURRENCY = new HashMap<>() {{
       put("Рубль", 1);
       put("Американский доллар", 75);
       put("Евро", 80);
       put("Золото", 4415);
       put("Серебро", 50);
       put("Платина", 2300);
    }};
}
