package com.patskevich.planetexpress.controller;

import com.patskevich.planetexpress.dto.EmployeeDto;
import com.patskevich.planetexpress.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(EmployeeController.CURRENT_PAGE_URL)
public class EmployeeController {

    public static final String CURRENT_PAGE_URL = "/employee";
    private final EmployeeService employeeService;

    @GetMapping("/list")
    public List<EmployeeDto> getEmployeeList() {
        return employeeService.getEmployeeList();
    }
}
