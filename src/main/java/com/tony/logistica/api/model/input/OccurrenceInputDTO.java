package com.tony.logistica.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OccurrenceInputDTO {

    @NotBlank
    private String description;
}
