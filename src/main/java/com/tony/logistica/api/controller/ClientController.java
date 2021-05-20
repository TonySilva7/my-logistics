package com.tony.logistica.api.controller;

import com.tony.logistica.domain.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @GetMapping("/clients")
    public List<Client> helloWorld() {


        Client client1 = new Client(1L, "João", "joao@mail", "333-4444");
        Client client2 = new Client(1L, "Maria", "maria@mail", "1111-3422");

        System.out.println();

        boolean kkk = client1.equals(client2);

        log.info("A comparação é: " + kkk);

        return Arrays.asList(client1, client2);
    }
}
