package com.tony.logistica.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Recipient {

    @Column(name = "name_recipient")
    private String name;

    @Column(name = "street_recipient")
    private String street;

    @Column(name = "number_recipient")
    private String number;

    @Column(name = "complement_recipient")
    private String complement;

    @Column(name = "district_recipient")
    private String district;
}
