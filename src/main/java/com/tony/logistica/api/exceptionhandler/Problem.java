package com.tony.logistica.api.exceptionhandler;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Problem {

    private Integer status;
    private LocalDateTime timeStamp;
    private String title;
    private List<MyErrorFields> fields;
}
