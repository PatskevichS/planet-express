package com.patskevich.planetexpress.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyDto {

    private String name;
    private String slogan;
    private String planet;
    private String location;
    private int age;
    private String business;
    private String owner;
    private int numberOfEmployees;
    private int numberOfShips;
}
