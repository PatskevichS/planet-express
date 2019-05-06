package com.patskevich.planetexpress.converter;

import com.patskevich.planetexpress.dto.ShipDto;
import com.patskevich.planetexpress.entity.Ship;
import com.patskevich.planetexpress.repository.EmployeeRepository;
import com.patskevich.planetexpress.utils.IdWriter;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@AllArgsConstructor
public class ShipConverter implements IDtoEntityConverter<ShipDto, Ship> {
    // REPOSITORIES
    private EmployeeRepository employeeRepository;

    public ShipDto convertToDto(final Ship ship) {
        final ShipDto shipDto = new ShipDto();
        shipDto.setName(IdWriter.write(ship.getId(), ship.getName()));
        shipDto.setCaptain(getEmployeeName(ship.getCaptain()));
        shipDto.setPilot(getEmployeeName(ship.getPilot()));
        BeanUtils.copyProperties(ship, shipDto, "name", "captain", "pilot");
        return shipDto;
    }

    public Ship convertToEntity(final ShipDto shipDto) {
        Assert.isTrue(false, "This shall never happen");
        return null;
    }

    private String getEmployeeName(final Long id) {
        if (id != null) { // TODO no assigned
            return IdWriter.write(id, employeeRepository.getOne(id).getName());
        } else {
            return null;
        }
    }
}
