package com.patskevich.planetexpress.converter;

import com.patskevich.planetexpress.dto.ShipDto;
import com.patskevich.planetexpress.entity.Ship;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ShipConverter implements IDtoEntityConverter<ShipDto,Ship> {

    public ShipDto convertToDto(final Ship ship) {
        final ShipDto shipDto = new ShipDto();
        BeanUtils.copyProperties(ship, shipDto);
        return shipDto;
    }

    public Ship convertToEntity(final ShipDto shipDto) {
        final Ship ship = new Ship();
        BeanUtils.copyProperties(shipDto, ship);
        return ship;
    }
}
