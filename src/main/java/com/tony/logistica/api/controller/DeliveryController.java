package com.tony.logistica.api.controller;

import com.tony.logistica.domain.model.Delivery;
import com.tony.logistica.domain.repository.DeliveryRepository;
import com.tony.logistica.domain.service.DeliveryRequestService;
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

    private final DeliveryRequestService deliveryRequestService;
    private final DeliveryRepository deliveryRepository;

    @GetMapping
    public List<Delivery> getAllDeliver() {
        return deliveryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliverById(@PathVariable Long id) {
        return deliveryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery saveDelivery(@Valid @RequestBody Delivery delivery) {

        return deliveryRequestService.requestDelivery(delivery);
    }
}
