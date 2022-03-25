package com.mirraim.e_lib_clients.service;

import com.mirraim.e_lib_clients.entity.Client;
import com.mirraim.e_lib_clients.model.EditClientRequest;

public interface ClientsService {

    Client getClient(Long id);
    Client addClient(Client client);
    Client editClient(Long id, EditClientRequest request);
}
