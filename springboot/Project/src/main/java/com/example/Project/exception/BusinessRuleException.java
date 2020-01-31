package com.example.Project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BussinessRuleException
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BusinessRuleException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 8894997794956849935L;

    public BusinessRuleException(String message) {
        super(message);
    }

    public BusinessRuleException(String message, Throwable e) {
        super(message, e);
    }
} 