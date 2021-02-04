package com.codurance.dip;

import lombok.AllArgsConstructor;

import java.time.MonthDay;

@AllArgsConstructor
public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Clock clock;
    private final EmailSender emailSender;

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(this::emailFor)
                .forEach(emailSender::send);
    }

    private Email emailFor(Employee employee) {
        return Email.builder()
                .to(employee.getEmail())
                .subject("Happy birthday!")
                .message(String.format("Happy birthday, dear %s!", employee.getFirstName()))
                .build();
    }
}