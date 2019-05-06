package com.patskevich.planetexpress.controller;

import com.patskevich.planetexpress.dto.DeliveryDto;
import com.patskevich.planetexpress.dto.requests.CreateDeliveryRequest;
import com.patskevich.planetexpress.exception.InternalServerException;
import com.patskevich.planetexpress.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(DeliveryController.CURRENT_PAGE_URL)
public class DeliveryController {

    public static final String CURRENT_PAGE_URL = "/delivery";
    private final DeliveryService deliveryService;

    @GetMapping("/list")
    public ResponseEntity<List<DeliveryDto>> getDeliveryList() {
        return ResponseEntity.status(HttpStatus.FOUND).body(deliveryService.getDeliveryList());
    }

    @GetMapping("/list/{clientId}")
    public ResponseEntity<List<DeliveryDto>> getDeliveryListForClient(final @PathVariable long clientId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(deliveryService.getDeliveryListForClient(clientId));
    }

    @GetMapping("/list/status/{status}")
    public ResponseEntity<List<DeliveryDto>> getDeliveryListByStatus(final @PathVariable String status) {
        return ResponseEntity.status(HttpStatus.FOUND).body(deliveryService.getDeliveryListByStatus(status));
    }

    @GetMapping("/list/status/{status}/{clientId}")
    public ResponseEntity<List<DeliveryDto>> getDeliveryListByStatusForClient(final @PathVariable String status,
                                                                              final @PathVariable long clientId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(deliveryService.getDeliveryListByStatusForClient(status, clientId));
    }

    @PostMapping("/accept/{deliveryId}/{shipID}")
    public ResponseEntity acceptToDelivering(final @PathVariable long deliveryId,
                                             final @PathVariable long shipID) {
        try {
            deliveryService.acceptToDelivering(deliveryId, shipID);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (InternalServerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/done/{deliveryId}")
    public ResponseEntity doneDelivering(final @PathVariable long deliveryId) {
        try {
            deliveryService.doneDelivering(deliveryId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (InternalServerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity createDelivery(final @RequestBody CreateDeliveryRequest request) {
        try {
            deliveryService.createDelivery(request);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (InternalServerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
