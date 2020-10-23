package com.codurance.ocp;

public class Manager extends Employee {
    public Manager(int salary, int bonus) {
        super(salary, bonus);
    }

    @Override
    public int payAmount() {
        return this.salary + this.bonus;
    }
}
