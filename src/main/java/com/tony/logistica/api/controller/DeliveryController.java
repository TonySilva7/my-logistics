package com.tony.logistica.api.controller;

import com.tony.logistica.domain.model.Delivery;
import com.tony.logistica.domain.service.DeliveryRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryRequestService deliveryRequestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery requestDelivery(@RequestBody Delivery delivery) {

        return deliveryRequestService.requestDelivery(delivery);
    }
}
