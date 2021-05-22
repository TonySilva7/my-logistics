package com.tony.logistica.api.mappers;

import com.tony.logistica.api.model.DeliveryDTO;
import com.tony.logistica.api.model.RecipientDTO;
import com.tony.logistica.api.model.input.DeliveryInputDTO;
import com.tony.logistica.domain.model.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliverMapper {

    private final ModelMapper modelMapper;

    public DeliveryDTO toDTO(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryDTO.class);
    }

    public List<DeliveryDTO> toCollectionDTO(List<Delivery> deliveries) {
        return deliveries.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryInputDTO deliveryInputDTO) {
        return modelMapper.map(deliveryInputDTO, Delivery.class);
    }
}
