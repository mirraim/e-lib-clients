package com.mirraim.e_lib_clients.service.impl;

import com.mirraim.e_lib_clients.data.ClientRepository;
import com.mirraim.e_lib_clients.entity.Client;
import com.mirraim.e_lib_clients.exception.NoFoundClientException;
import com.mirraim.e_lib_clients.model.EditClientRequest;
import com.mirraim.e_lib_clients.service.ClientsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService {

    private final ClientRepository clientRepository;


    @Override
    @Transactional
    public Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow(NoFoundClientException::new);
    }

    @Override
    @Transactional
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Client editClient(Long id, EditClientRequest request) {
        Client client = clientRepository.findById(id).orElseThrow(NoFoundClientException::new);
        if (request.getEmail() != null) {
            client.setEmail(request.getEmail());
        }
        if (request.getName() != null) {
            client.setName(request.getName());
        }
        return client;
    }
}
