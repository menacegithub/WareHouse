package org.example.extratomeee.service;

import org.example.extratomeee.dto.ClientDto;
import org.example.extratomeee.model.Client;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Integer id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            return clientOptional.get();
        }
        return null;
    }

    public Result addClient(ClientDto clientDto) {
        boolean existed = clientRepository.existByName2(clientDto.getName());
        if (existed) {
            return new Result(false, "Client with this name already exists");
        }
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setPhonenumber(clientDto.getPhonenumber());
        clientRepository.save(client);
        return new Result(true, "Client added successfully");
    }

    public Result updateClient(ClientDto clientDto,Integer id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setName(clientDto.getName());
            client.setPhonenumber(clientDto.getPhonenumber());
            clientRepository.save(client);
            return new Result(true, "Client updated");
        }
        return new Result(false, "Client not found");
    }

    public Result deleteClient(Integer id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            clientRepository.delete(client);
            return new Result(true, "Client deleted");
        }
        return new Result(false, "Client not found");
    }
}
