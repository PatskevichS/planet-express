package com.patskevich.planetexpress.converter;

import com.patskevich.planetexpress.dto.CompanyDto;
import com.patskevich.planetexpress.entity.Company;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CompanyConverter implements IDtoEntityConverter<CompanyDto, Company> {

    public CompanyDto convertToDto(final Company company) {
        final CompanyDto companyDto = new CompanyDto();
        BeanUtils.copyProperties(company, companyDto);
        return companyDto;
    }

    public Company convertToEntity(final CompanyDto companyDto) {
        Assert.isTrue(false,"This shall never happen");
        return null;
    }
}
