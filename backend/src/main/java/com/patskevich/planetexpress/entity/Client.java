package com.patskevich.planetexpress.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CLIENTS")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private String name;
}