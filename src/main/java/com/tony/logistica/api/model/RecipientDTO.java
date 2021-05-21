package com.tony.logistica.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientDTO {

    private String name;
    private String street;
    private String number;
    private String complement;
    private String district;
}
