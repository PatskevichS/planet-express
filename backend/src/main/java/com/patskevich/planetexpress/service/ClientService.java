package com.patskevich.planetexpress.service;

import com.patskevich.planetexpress.converter.ClientConverter;
import com.patskevich.planetexpress.dto.ClientDto;
import com.patskevich.planetexpress.dto.requests.CreateClientRequest;
import com.patskevich.planetexpress.entity.Client;
import com.patskevich.planetexpress.exception.impl.ClientException;
import com.patskevich.planetexpress.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {
    // REPOSITORIES
    private final ClientRepository clientRepository;
    // CONVERTERS
    private final ClientConverter clientConverter;

    public List<ClientDto> getClientList() {
        return clientRepository.findAll().stream().map(clientConverter::convertToDto).collect(Collectors.toList());
    }

    public void createClient(CreateClientRequest request){
        final Client client = new Client();
        client.setLogin(request.getLogin());
        client.setPassword(request.getPassword());
        client.setName(request.getName());
        clientRepository.save(client);
    }

    public Client findClient(final long id) throws ClientException {
        final Client client = clientRepository.findById(id).orElse(null);
        if (client== null){
            throw new ClientException("Error. Client does not exist!");
        } else {
            return client;
        }
    }
}
