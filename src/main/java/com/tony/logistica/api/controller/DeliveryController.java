package com.tony.logistica.api.controller;

import com.tony.logistica.api.mappers.DeliverMapper;
import com.tony.logistica.api.model.DeliveryDTO;
import com.tony.logistica.api.model.input.DeliveryInputDTO;
import com.tony.logistica.domain.model.Delivery;
import com.tony.logistica.domain.repository.DeliveryRepository;
import com.tony.logistica.domain.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final DeliveryRepository deliveryRepository;
    private final DeliverMapper deliverMapper;

    @GetMapping
    public List<DeliveryDTO> getAllDeliveries() {

        return deliverMapper.toCollectionDTO(deliveryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDTO> getDeliverById(@PathVariable Long id) {
        return deliveryRepository.findById(id)
                .map(delivery -> ResponseEntity.ok(deliverMapper.toDTO(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDTO saveDelivery(@Valid @RequestBody DeliveryInputDTO deliveryInputDTO) {
        Delivery newDelivery = deliverMapper.toEntity(deliveryInputDTO);
        Delivery deliveryRequest = deliveryService.saveDelivery(newDelivery);
        return deliverMapper.toDTO(deliveryRequest);
    }
}
