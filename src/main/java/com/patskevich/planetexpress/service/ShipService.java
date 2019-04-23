package com.patskevich.planetexpress.service;

import com.patskevich.planetexpress.converter.ShipConverter;
import com.patskevich.planetexpress.dto.ShipDto;
import com.patskevich.planetexpress.repository.ShipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShipService {

    private final ShipRepository shipRepository;
    private final ShipConverter shipConverter;

    public List<ShipDto> getShipList() {
        return shipRepository.findAll().stream().map(shipConverter::convertToDto).collect(Collectors.toList());
    }
}
