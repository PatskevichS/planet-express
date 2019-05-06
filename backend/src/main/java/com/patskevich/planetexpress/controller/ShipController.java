package com.patskevich.planetexpress.controller;

import com.patskevich.planetexpress.dto.ShipDto;
import com.patskevich.planetexpress.dto.requests.CreateShipRequest;
import com.patskevich.planetexpress.exception.InternalServerException;
import com.patskevich.planetexpress.service.ShipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(ShipController.CURRENT_PAGE_URL)
public class ShipController {

    public static final String CURRENT_PAGE_URL = "/ship";
    private final ShipService shipService;

    @GetMapping("/list")
    public ResponseEntity<List<ShipDto>> getShipList() {
        return ResponseEntity.status(HttpStatus.FOUND).body(shipService.getShipList());
    }

    @PostMapping("/create")
    public ResponseEntity createShip(final @RequestBody CreateShipRequest request) {
        shipService.createShip(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/change_captain/{shipId}/{employeeId}")
    public ResponseEntity changeCaptain(final @PathVariable long shipId, final @PathVariable long employeeId) {
        try {
            shipService.changeCaptain(shipId, employeeId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (InternalServerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/change_pilot/{shipId}/{employeeId}")
    public ResponseEntity changePilot(final @PathVariable long shipId, final @PathVariable long employeeId) {
        try {
            shipService.changePilot(shipId, employeeId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (InternalServerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
