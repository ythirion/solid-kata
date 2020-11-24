package com.codurance.dip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Email {
    private final String to;
    private final String subject;
    private final String message;
}
