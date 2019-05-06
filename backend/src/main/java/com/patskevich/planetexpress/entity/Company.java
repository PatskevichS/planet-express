package com.patskevich.planetexpress.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
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