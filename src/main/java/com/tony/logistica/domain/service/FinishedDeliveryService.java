package com.tony.logistica.domain.service;

import com.tony.logistica.domain.model.Delivery;
import com.tony.logistica.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinishedDeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final FindDeliveryService findDeliveryService;

    @Transactional
    public void finishedDelivery(Long id) {
        Delivery delivery = findDeliveryService.findDelivery(id);
        delivery.setFinished();
        deliveryRepository.save(delivery);
    }
}
