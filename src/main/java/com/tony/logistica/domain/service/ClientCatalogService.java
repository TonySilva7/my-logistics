package com.tony.logistica.domain.service;

import com.tony.logistica.domain.exception.DomainException;
import com.tony.logistica.domain.model.Client;
import com.tony.logistica.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientCatalogService {

    private ClientRepository clientRepository;

    public Client findClient(Long id) {
        return  clientRepository.findById(id)
                .orElseThrow(() -> new DomainException("Cliente não encontrado"));
    }

    @Transactional
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Client saveClient(Client client) {
        boolean hasEmailClient = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(clientDB -> !clientDB.equals(client));
        if (hasEmailClient) {
            throw new DomainException("Já existe um cliente com este email");
        }
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public boolean hasIdClient(Long id) {
        return clientRepository.existsById(id);
    }
}
