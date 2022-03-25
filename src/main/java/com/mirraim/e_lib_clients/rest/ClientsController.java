package com.mirraim.e_lib_clients.rest;

import com.mirraim.e_lib_clients.entity.Client;
import com.mirraim.e_lib_clients.model.EditClientRequest;
import com.mirraim.e_lib_clients.service.ClientsService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientsController {
    private static final String TAG = "Клиенты";

    private final ClientsService clientsService;

    @ApiOperation(value = "Получить клиента по id", tags = {TAG})
    @GetMapping("client/{id}")
    public Client getClientById(@PathVariable("id") Long id) {
        return clientsService.getClient(id);
    }

    @ApiOperation(value = "Создать клиента", tags = {TAG})
    @PostMapping("client/create")
    public Client addClient(@RequestBody Client client) {
        return clientsService.addClient(client);
    }

    @ApiOperation(value = "Редактировать клиента", tags = {TAG})
    @PostMapping("client/{id}/edit")
    public Client editClient(@PathVariable("id") Long id, @RequestBody EditClientRequest editRequest) {
        return clientsService.editClient(id, editRequest);
    }
}
