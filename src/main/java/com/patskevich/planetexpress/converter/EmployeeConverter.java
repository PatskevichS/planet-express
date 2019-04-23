package com.patskevich.planetexpress.converter;

import com.patskevich.planetexpress.dto.EmployeeDto;
import com.patskevich.planetexpress.entity.Employee;
import com.patskevich.planetexpress.entity.Ship;
import com.patskevich.planetexpress.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeConverter implements IDtoEntityConverter<EmployeeDto, Employee> {

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private ShipConverter shipConverter;

    public EmployeeDto convertToDto(final Employee employee) {
        final EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setGender(employee.getGender());
        employeeDto.setSpecies(employee.getSpecies());
        employeeDto.setPlanet(employee.getPlanet());
        setShipToDto(employeeDto, employee);
        employeeDto.setProfession(employee.getProfession());
        return employeeDto;
    }

    public Employee convertToEntity(final EmployeeDto employeeDto) {
        final Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setGender(employeeDto.getGender());
        employee.setSpecies(employeeDto.getSpecies());
        employee.setPlanet(employeeDto.getPlanet());
        setShipToEntity(employee, employeeDto);
        employee.setProfession(employeeDto.getProfession());
        return employee;
    }

    private void setShipToDto(final EmployeeDto employeeDto, final Employee employee) {
        if (employee.getShip() != null) {
            Optional<Ship> shipFromStore = shipRepository.findById(employee.getShip());
            employeeDto.setShip(shipConverter.convertToDto(shipFromStore.orElse(null)));
        }
    }

    private void setShipToEntity(final Employee employe, final EmployeeDto employeeDto) {
        if (employeeDto.ifShipExist()) {
            // TODO something
        } else {
            employe.setShip(null);
        }
    }
}