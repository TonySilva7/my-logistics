package com.tony.logistica.domain.service;

import com.tony.logistica.domain.exception.DomainException;
import com.tony.logistica.domain.model.Delivery;
import com.tony.logistica.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindDeliveryService {
    public final DeliveryRepository deliveryRepository;

    public Delivery findDelivery(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new DomainException("Entrega não encontrada"));
    }
}