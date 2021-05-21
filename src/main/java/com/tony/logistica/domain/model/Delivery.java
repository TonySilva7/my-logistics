package com.tony.logistica.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tony.logistica.domain.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    @NotNull
    @ManyToOne
    private Client client;

    @Valid
    @NotNull
    @Embedded
    private Recipient recipient;

    @NotNull
    private BigDecimal fee;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime orderDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime deliveryDate;
}
