package com.patskevich.planetexpress.controller;

import com.patskevich.planetexpress.dto.CompanyDto;
import com.patskevich.planetexpress.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(CompanyController.CURRENT_PAGE_URL)
public class CompanyController {

    public static final String CURRENT_PAGE_URL = "/company";
    private final CompanyService companyService;

    @GetMapping("/info")
    public CompanyDto getCompanyInfo() {
        return companyService.getCompanyInfo();
    }
}
