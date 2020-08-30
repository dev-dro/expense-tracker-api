package com.devdro.expensetracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EtAuthExpcetion extends RuntimeException {

    public EtAuthExpcetion(String message) {
        super(message);
    }
}
