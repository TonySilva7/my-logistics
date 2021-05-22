package com.tony.logistica.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Valid
    //@ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    //@NotNull
    @ManyToOne
    private Client client;

    //@Valid
    //@NotNull
    @Embedded
    private Recipient recipient;

    //@NotNull
    private BigDecimal fee;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences = new ArrayList<>();

    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime orderDate;

    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime deliveryDate;

    public Occurrence addOccurrence(String description) {
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);
        occurrence.setRecordDate(OffsetDateTime.now());
        occurrence.setDelivery(this);

        this.getOccurrences().add(occurrence);

        return occurrence;
    }
}
