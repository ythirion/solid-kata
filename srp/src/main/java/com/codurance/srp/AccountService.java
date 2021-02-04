package com.codurance.srp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountService {

    private final TransactionRepository transactionRepository;
    private final StatementPrinter statementPrinter;
    private final Clock clock;

    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.all());
    }

    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }
}