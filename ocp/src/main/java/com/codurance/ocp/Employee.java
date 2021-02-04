package com.codurance.ocp;

public abstract class Employee implements Payable {
    protected final int salary;
    protected final int bonus;

    public Employee(int salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }
}