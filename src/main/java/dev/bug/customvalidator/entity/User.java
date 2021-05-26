package dev.bug.customvalidator.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {

    private Long id;
    private final String name;
    private final LocalDate birthday;
    private final String email;
}
