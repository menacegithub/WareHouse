package org.example.extratomeee.controller;

import org.example.extratomeee.dto.ClientDto;
import org.example.extratomeee.model.Client;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.repository.ClientRepository;
import org.example.extratomeee.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    @GetMapping
    public Client getClientById(@RequestParam int id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Result addClient(@RequestBody ClientDto clientDto) {
        Result addedClient = clientService.addClient(clientDto);
        return addedClient;
    }
    @PutMapping
    public Result updateClient(@PathVariable Integer id,@RequestBody ClientDto clientDto) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setName(clientDto.getName());
            client.setPhonenumber(clientDto.getPhonenumber());
            return new Result(true,"Successfully updated");
        }
        return new Result(false,"Client not found");
    }
    @DeleteMapping
    public Result deleteClient(@PathVariable Integer id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            clientRepository.deleteById(id);
            return new Result(true, "Client deleted");
        }
        return new Result(false,"Not deleted");
    }

}
