package com.patskevich.planetexpress.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    private int age;
    private String gender;
    private String species;
    private String planet;
    private Long ship;
    private String profession;
}
