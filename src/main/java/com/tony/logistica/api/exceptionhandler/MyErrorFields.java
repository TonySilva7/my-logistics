package com.tony.logistica.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MyErrorFields {

    private String fieldName;
    private String message;
}
