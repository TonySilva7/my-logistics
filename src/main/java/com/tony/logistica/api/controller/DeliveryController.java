package com.tony.logistica.api.controller;

import com.tony.logistica.api.mappers.DeliverMapper;
import com.tony.logistica.api.model.DeliveryDTO;
import com.tony.logistica.api.model.input.DeliveryInputDTO;
import com.tony.logistica.domain.model.Delivery;
import com.tony.logistica.domain.repository.DeliveryRepository;
import com.tony.logistica.domain.service.DeliveryService;
import com.tony.logistica.domain.service.FinishedDeliveryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final DeliveryRepository deliveryRepository;
    private final DeliverMapper deliverMapper;
    private final FinishedDeliveryService finishedDeliveryService;

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

    @PutMapping("/{id}/finished")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finishDeliver(@PathVariable Long id) {
        log.warn("Passei no controller: /deliveries/{id}/finished");
        finishedDeliveryService.finishedDelivery(id);
    }
}
