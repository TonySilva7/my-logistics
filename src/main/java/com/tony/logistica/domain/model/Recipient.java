package com.tony.logistica.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
public class Recipient {

    @NotBlank
    @Column(name = "name_recipient")
    private String name;

    @NotBlank
    @Column(name = "street_recipient")
    private String street;

    @NotBlank
    @Column(name = "number_recipient")
    private String number;

    @NotBlank
    @Column(name = "complement_recipient")
    private String complement;

    @NotBlank
    @Column(name = "district_recipient")
    private String district;
}
