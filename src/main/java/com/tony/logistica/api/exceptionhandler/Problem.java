package com.tony.logistica.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem {

    private Integer status;
    private OffsetDateTime timeStamp;
    private String title;
    private List<MyErrorFields> fields;
}
