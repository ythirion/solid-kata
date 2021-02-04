package com.codurance.srp;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Transaction {
    private final LocalDate date;
    private final int amount;
}
