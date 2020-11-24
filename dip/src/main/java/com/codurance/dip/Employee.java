package com.codurance.dip;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Employee {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String email;
}
