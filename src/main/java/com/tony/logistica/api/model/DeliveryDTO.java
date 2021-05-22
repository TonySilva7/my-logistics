package com.tony.logistica.api.model;

import com.tony.logistica.domain.model.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryDTO {

    private Long id;
    private ClientSummaryDTO client;
    private String clientName;
    private RecipientDTO recipient;
    private BigDecimal fee;
    private DeliveryStatus status;
    private OffsetDateTime orderDate;
    private OffsetDateTime deliveryDate;
}
