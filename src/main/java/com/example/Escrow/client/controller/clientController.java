package com.example.Escrow.client.controller;

import com.example.Escrow.client.entity.client;
import com.example.Escrow.client.service.clientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class clientController {

    private final clientService clientService;


    public clientController(clientService clientService) {
        this.clientService = clientService;
    }


    // CREATE CLIENT
    @PostMapping
    public ResponseEntity<client> createClient(
            @RequestBody client client) {

        client createdClient =
                clientService.createClient(client);

        return new ResponseEntity<>(
                createdClient,
                HttpStatus.CREATED
        );
    }


    // GET ALL CLIENTS
    @GetMapping
    public ResponseEntity<List<client>> getAllClients() {

        List<client> clients =
                clientService.getAllClients();

        return new ResponseEntity<>(
                clients,
                HttpStatus.OK
        );
    }


    // GET CLIENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<client> getClientById(
            @PathVariable Long id) {

        client client =
                clientService.getClientById(id);

        return new ResponseEntity<>(
                client,
                HttpStatus.OK
        );
    }


    // UPDATE CLIENT
    @PutMapping("/{id}")
    public ResponseEntity<client> updateClient(
            @PathVariable Long id,
            @RequestBody client updatedClient) {

        client client =
                clientService.updateClient(
                        id,
                        updatedClient
                );

        return new ResponseEntity<>(
                client,
                HttpStatus.OK
        );
    }


    // DELETE CLIENT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(
            @PathVariable Long id) {

        String message =
                clientService.deleteClient(id);

        return new ResponseEntity<>(
                message,
                HttpStatus.OK
        );
    }
}