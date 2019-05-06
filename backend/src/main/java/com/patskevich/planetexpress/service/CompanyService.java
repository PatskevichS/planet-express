package com.patskevich.planetexpress.service;

import com.patskevich.planetexpress.converter.CompanyConverter;
import com.patskevich.planetexpress.dto.CompanyDto;
import com.patskevich.planetexpress.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {
    // REPOSITORIES
    private final CompanyRepository companyRepository;
    // CONVERTERS
    private final CompanyConverter companyConverter;

    public CompanyDto getCompanyInfo() {
        return companyConverter.convertToDto(companyRepository.getOne(1L));
    }
}
