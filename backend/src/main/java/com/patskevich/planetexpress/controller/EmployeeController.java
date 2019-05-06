package com.patskevich.planetexpress.controller;

import com.patskevich.planetexpress.dto.EmployeeDto;
import com.patskevich.planetexpress.exception.InternalServerException;
import com.patskevich.planetexpress.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(EmployeeController.CURRENT_PAGE_URL)
public class EmployeeController {

    public static final String CURRENT_PAGE_URL = "/employee";
    private final EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDto>> getEmployeeList() {
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.getEmployeeList());
    }

    @PostMapping("/removing/{employeeId}")
    public ResponseEntity removing(final @PathVariable long employeeId) {
        try {
            employeeService.removing(employeeId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (InternalServerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
