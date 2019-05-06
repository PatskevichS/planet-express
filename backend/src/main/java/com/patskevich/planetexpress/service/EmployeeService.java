package com.patskevich.planetexpress.service;

import com.patskevich.planetexpress.converter.EmployeeConverter;
import com.patskevich.planetexpress.dto.EmployeeDto;
import com.patskevich.planetexpress.entity.Employee;
import com.patskevich.planetexpress.entity.Ship;
import com.patskevich.planetexpress.exception.impl.EmployeeException;
import com.patskevich.planetexpress.repository.EmployeeRepository;
import com.patskevich.planetexpress.repository.ShipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {
    // REPOSITORIES
    private final EmployeeRepository employeeRepository;
    private final ShipRepository shipRepository;
    // CONVERTERS
    private final EmployeeConverter employeeConverter;

    public List<EmployeeDto> getEmployeeList() {
        return employeeRepository.findAll().stream().map(employeeConverter::convertToDto).collect(Collectors.toList());
    }

    public void updateEmployeeShip(final Employee employee, Long shipId) {
        employee.setShip(shipId);
        employeeRepository.save(employee);
    }

    public void updateEmployeeShip(final Long employeeId, Long shipId) {
        final Employee employee = employeeRepository.getOne(employeeId);
        employee.setShip(shipId);
        employeeRepository.save(employee);
    }

    public void removing(final long employeeId) throws EmployeeException {
        final Employee employee = findEmployee(employeeId);
        if (employee.getShip() != null) {
            removingEmploye(employee.getShip(), employeeId);
        }
        employee.setShip(null);
        employeeRepository.save(employee);
    }

    public Employee findEmployee(final long id) throws EmployeeException {
        final Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            throw new EmployeeException("Error. Ship does not exist!");
        } else {
            return employee;
        }
    }

    private void removingEmploye(final long shipId, final long employeeId) {
        final Ship ship = shipRepository.getOne(shipId);
        if (ship.getCaptain() != null && ship.getCaptain() == employeeId) {
            ship.setCaptain(null);
        } else {
            ship.setPilot(null);
        }
        shipRepository.save(ship);
    }
}
