package com.example.Escrow.client.service;

import com.example.Escrow.client.entity.client;
import com.example.Escrow.client.repository.clientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clientService {

    private final clientRepository clientRepository;


    public clientService(clientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    // CREATE CLIENT
    public client createClient(client client) {

        if (client.getName() == null ||
                client.getName().trim().isEmpty()) {

            throw new RuntimeException("Client name is required");
        }

        if (client.getEmail() == null ||
                client.getEmail().trim().isEmpty()) {

            throw new RuntimeException("Client email is required");
        }

        return clientRepository.save(client);
    }


    // GET ALL CLIENTS
    public List<client> getAllClients() {

        return clientRepository.findAll();
    }


    // GET CLIENT BY ID
    public client getClientById(Long id) {

        Optional<client> result =
                clientRepository.findById(id);

        if (result.isEmpty()) {

            throw new RuntimeException(
                    "Client not found with id: " + id
            );
        }

        return result.get();
    }


    // UPDATE CLIENT
    public client updateClient(Long id, client updatedClient) {

        client existingClient =
                getClientById(id);


        if (updatedClient.getName() != null &&
                !updatedClient.getName().trim().isEmpty()) {

            existingClient.setName(
                    updatedClient.getName()
            );
        }


        if (updatedClient.getEmail() != null &&
                !updatedClient.getEmail().trim().isEmpty()) {

            existingClient.setEmail(
                    updatedClient.getEmail()
            );
        }


        return clientRepository.save(existingClient);
    }


    // DELETE CLIENT
    public String deleteClient(Long id) {

        if (!clientRepository.existsById(id)) {

            throw new RuntimeException(
                    "Client not found with id: " + id
            );
        }

        clientRepository.deleteById(id);

        return "Client deleted successfully";
    }
}