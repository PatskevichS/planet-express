package com.patskevich.planetexpress.service;

import com.patskevich.planetexpress.converter.ShipConverter;
import com.patskevich.planetexpress.dto.ShipDto;
import com.patskevich.planetexpress.dto.requests.CreateShipRequest;
import com.patskevich.planetexpress.entity.Employee;
import com.patskevich.planetexpress.entity.Ship;
import com.patskevich.planetexpress.exception.InternalServerException;
import com.patskevich.planetexpress.exception.impl.EmployeeException;
import com.patskevich.planetexpress.exception.impl.ShipException;
import com.patskevich.planetexpress.repository.ShipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShipService {
    // SERVICES
    private final EmployeeService employeeService;
    // REPOSITORIES
    private final ShipRepository shipRepository;
    // CONVERTERS
    private final ShipConverter shipConverter;

    public List<ShipDto> getShipList() {
        return shipRepository.findAll().stream().map(shipConverter::convertToDto).collect(Collectors.toList());
    }

    public void createShip(final CreateShipRequest request) {
        final Ship ship = new Ship();
        ship.setName(request.getName());
        ship.setColor(request.getColor());
        ship.setSpecies(request.getSpecies());
        shipRepository.save(ship);
    }

    public void changeCaptain(final long shipId, final long employeeId) throws InternalServerException {
        final Ship ship = findShip(shipId);
        Employee employee = employeeService.findEmployee(employeeId);
        if (ship.getCaptain()!=null){
            employeeService.updateEmployeeShip(ship.getCaptain(), null);
        }
        updateEmployeeShip(employee, shipId);
        ship.setCaptain(employee.getId());
        shipRepository.save(ship);
    }

    public void changePilot(long shipId, long employeeId) throws InternalServerException {
        final Ship ship = findShip(shipId);
        Employee employee = employeeService.findEmployee(employeeId);
        if (ship.getPilot()!=null){
            employeeService.updateEmployeeShip(ship.getPilot(), null);
        }
        updateEmployeeShip(employee, shipId);
        ship.setPilot(employee.getId());
        shipRepository.save(ship);
    }

    public Ship findShip(final long id) throws ShipException {
        final Ship ship = shipRepository.findById(id).orElse(null);
        if (ship == null) {
            throw new ShipException("Error. Ship does not exist!");
        } else {
            return ship;
        }
    }

    public void validateShip(final Ship ship) throws ShipException {
        if (!ship.hasCaptain() || !ship.hasPilot()) {
            throw new ShipException("There is no pilot or captain on the ship");
        }
    }

    private void updateEmployeeShip(final Employee employee, long shipId) throws EmployeeException {
        employeeService.removing(employee.getId());
        employeeService.updateEmployeeShip(employee, shipId);//TODO message
    }
}
