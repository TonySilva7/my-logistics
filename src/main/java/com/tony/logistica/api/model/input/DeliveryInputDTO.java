package com.tony.logistica.api.model.input;

import com.tony.logistica.domain.model.Client;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryInputDTO {

    @Valid
    @NotNull
    private ClientIdInput client;

    @Valid
    @NotNull
    private RecipientInput recipient;

    @NotNull
    private BigDecimal fee;
}
