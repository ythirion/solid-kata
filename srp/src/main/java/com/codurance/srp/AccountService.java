package com.codurance.srp;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

public class AccountService {

    private final TransactionRepository transactionRepository;
    private final Clock clock;
    private final StatementPrinter statementPrinter;

    public AccountService(TransactionRepository transactionRepository,
                          StatementPrinter statementPrinter,
                          Clock clock) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.all());
    }

    private void printTransactions() {

    }

    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }
}