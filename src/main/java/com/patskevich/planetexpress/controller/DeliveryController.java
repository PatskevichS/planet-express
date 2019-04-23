package com.patskevich.planetexpress.controller;

import com.patskevich.planetexpress.dto.DeliveryDto;
import com.patskevich.planetexpress.dto.requests.CreateDeliveryRequest;
import com.patskevich.planetexpress.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(DeliveryController.CURRENT_PAGE_URL)
public class DeliveryController {   // TODO ResponseEntity

    public static final String CURRENT_PAGE_URL = "/delivery";
    private final DeliveryService deliveryService;

    @GetMapping("/list")
    public List<DeliveryDto> getDeliveryList() {
        return deliveryService.getDeliveryList();
    }

    @PostMapping("/create")
    public void createDelivery(final @RequestBody CreateDeliveryRequest request) {
        deliveryService.createDelivery(request);
    }
}
