package com.patskevich.planetexpress.service;

import com.patskevich.planetexpress.converter.EmployeeConverter;
import com.patskevich.planetexpress.dto.EmployeeDto;
import com.patskevich.planetexpress.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;

    public List<EmployeeDto> getEmployeeList() {
        return employeeRepository.findAll().stream().map(employeeConverter::convertToDto).collect(Collectors.toList());
    }
}
