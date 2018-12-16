package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Customer {

    private Long id;
    private String name;
    private String nickname;
    private int age;

}
