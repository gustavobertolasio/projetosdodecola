package com.example.Project.service;

import java.util.List;
import java.util.Optional;

import com.example.Project.domain.entities.Client;
import com.example.Project.exception.DataNotFoundException;
import com.example.Project.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client model) {
        return clientRepository.save(model);
    }

    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    public Client findById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new DataNotFoundException("Client Not found"));
    }

    public Client updateClient(Client model) {
        return clientRepository.save(model);
    }

    public void deleteClient(Client cliente) {
        findById(cliente.getId());
        clientRepository.deleteById(cliente.getId());
    }

    public List<String> listDistinct() {
        return clientRepository.listDistinct();
    }

    public List<Client> listByPhone(String phone) {
        return clientRepository.findByPhone(phone);
    }

}