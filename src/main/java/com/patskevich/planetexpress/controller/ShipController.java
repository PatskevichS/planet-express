package com.patskevich.planetexpress.controller;

import com.patskevich.planetexpress.dto.ShipDto;
import com.patskevich.planetexpress.service.ShipService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(ShipController.CURRENT_PAGE_URL)
public class ShipController {

    public static final String CURRENT_PAGE_URL = "/ship";
    private final ShipService shipService;

    @GetMapping("/list")
    public List<ShipDto> getShipList() {
        return shipService.getShipList();
    }
}
