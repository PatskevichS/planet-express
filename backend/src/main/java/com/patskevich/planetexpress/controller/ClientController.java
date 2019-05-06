package com.patskevich.planetexpress.controller;

import com.patskevich.planetexpress.dto.ClientDto;
import com.patskevich.planetexpress.dto.requests.CreateClientRequest;
import com.patskevich.planetexpress.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(ClientController.CURRENT_PAGE_URL)
public class ClientController {

    public static final String CURRENT_PAGE_URL = "/client";
    private final ClientService clientService;

    @GetMapping("/list")
    public ResponseEntity<List<ClientDto>> getClientList() {
        return ResponseEntity.status(HttpStatus.FOUND).body(clientService.getClientList());
    }

    @PostMapping("/create")
    public ResponseEntity createClient(final @RequestBody CreateClientRequest request) {
        clientService.createClient(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
