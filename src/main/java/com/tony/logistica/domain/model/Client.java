package com.tony.logistica.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private Long id;
    //    @EqualsAndHashCode.Exclude
    transient
    private String name;
    //    @EqualsAndHashCode.Exclude
    transient
    private String email;
    //    @EqualsAndHashCode.Exclude
    transient
    private String phone;
}
