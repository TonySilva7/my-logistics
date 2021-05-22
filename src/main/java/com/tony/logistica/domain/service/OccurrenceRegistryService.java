package com.tony.logistica.domain.service;

import com.tony.logistica.domain.exception.DomainException;
import com.tony.logistica.domain.model.Delivery;
import com.tony.logistica.domain.model.Occurrence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OccurrenceRegistryService {

    FindDeliveryService findDeliveryService;

    @Transactional
    public Occurrence registryOccurrence(Long id, String description) {

        Delivery delivery = findDeliveryService.findDelivery(id);
        return delivery.addOccurrence(description);
    }
}
