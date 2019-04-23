package com.patskevich.planetexpress.converter;

import com.patskevich.planetexpress.dto.EmployeeDto;
import com.patskevich.planetexpress.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConverter implements IDtoEntityConverter<EmployeeDto, Employee> {

    public EmployeeDto convertToDto(final Employee employee) {
        final EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }

    public Employee convertToEntity(final EmployeeDto employeeDto) {
        final Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }
}
