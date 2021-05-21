package com.tony.logistica.domain.service;

import com.tony.logistica.domain.exception.DomainException;
import com.tony.logistica.domain.model.Client;
import com.tony.logistica.domain.model.Delivery;
import com.tony.logistica.domain.model.DeliveryStatus;
import com.tony.logistica.domain.repository.ClientRepository;
import com.tony.logistica.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class DeliveryRequestService {

    private final ClientCatalogService clientCatalogService;
    private final DeliveryRepository deliveryRepository;

    @Transactional
    public Delivery requestDelivery(Delivery delivery) {

        Client client = clientCatalogService.findClient(delivery.getClient().getId());

        delivery.setClient(client);
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setOrderDate(LocalDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
