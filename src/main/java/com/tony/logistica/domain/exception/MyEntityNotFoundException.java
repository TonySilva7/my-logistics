package com.tony.logistica.domain.exception;

public class MyEntityNotFoundException extends DomainException {

    private static final long serialVersionUID = 1L;
    public MyEntityNotFoundException(String message) {
        super(message);
    }
}
