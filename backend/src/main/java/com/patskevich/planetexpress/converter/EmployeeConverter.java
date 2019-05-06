package com.patskevich.planetexpress.converter;

import com.patskevich.planetexpress.dto.EmployeeDto;
import com.patskevich.planetexpress.entity.Employee;
import com.patskevich.planetexpress.repository.ShipRepository;
import com.patskevich.planetexpress.utils.IdWriter;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@AllArgsConstructor
public class EmployeeConverter implements IDtoEntityConverter<EmployeeDto, Employee> {
    // REPOSITORIES
    private ShipRepository shipRepository;

    public EmployeeDto convertToDto(final Employee employee) {
        final EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(IdWriter.write(employee.getId(), employee.getName()));
        setShipToDto(employeeDto, employee);
        BeanUtils.copyProperties(employee, employeeDto, "name", "ship");
        return employeeDto;
    }

    public Employee convertToEntity(final EmployeeDto employeeDto) {
        Assert.isTrue(false, "This shall never happen");
        return null;
    }

    private void setShipToDto(final EmployeeDto employeeDto, final Employee employee) {
        if (employee.getShip() != null) {
            employeeDto.setShip(IdWriter.write(employee.getShip(), shipRepository.getOne(employee.getShip()).getName()));
        }
    }
}