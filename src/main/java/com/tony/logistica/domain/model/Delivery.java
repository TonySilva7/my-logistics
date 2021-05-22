package com.tony.logistica.domain.model;

import com.tony.logistica.domain.exception.DomainException;
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

    @ManyToOne
    private Client client;

    @Embedded
    private Recipient recipient;

    private BigDecimal fee;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private OffsetDateTime orderDate;

    private OffsetDateTime deliveryDate;

    public Occurrence addOccurrence(String description) {
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);
        occurrence.setRecordDate(OffsetDateTime.now());
        occurrence.setDelivery(this);

        this.getOccurrences().add(occurrence);

        return occurrence;
    }

    public void setFinished() {
        if (!canBeFinished()) {
            throw new DomainException("Entrega não pode ser finalizada");
        }

        setStatus(DeliveryStatus.FINISHED);
        setDeliveryDate(OffsetDateTime.now());
    }

    public boolean canBeFinished() {
        return DeliveryStatus.PENDING.equals(getStatus());
    }
}
