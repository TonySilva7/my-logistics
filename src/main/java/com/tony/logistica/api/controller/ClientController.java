package com.tony.logistica.api.controller;

import com.tony.logistica.domain.model.Client;
import com.tony.logistica.domain.repository.ClientRepository;
import com.tony.logistica.domain.service.ClientCatalogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientCatalogService clientCatalogService;

    @GetMapping
    public List<Client> getClients() {
        return clientCatalogService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {

        return clientCatalogService.findClientById(id)
                //.map(myClient -> ResponseEntity.ok(myClient))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@Valid @RequestBody Client client) {
        return clientCatalogService.saveClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateCliente(@PathVariable Long id, @Valid @RequestBody Client client) {

        if (!clientCatalogService.hasIdClient(id)) {
            return ResponseEntity.notFound().build();
        }

        client.setId(id);
        client = clientCatalogService.saveClient(client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {

        if (!clientCatalogService.hasIdClient(id)) {
            return ResponseEntity.notFound().build();
        }
        clientCatalogService.deleteClient(id);

        return ResponseEntity.noContent().build();
    }
}
