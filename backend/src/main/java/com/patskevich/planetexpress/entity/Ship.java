package com.patskevich.planetexpress.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SHIPS")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    private String species;
    private String color;
    private Long captain;
    private Long pilot;

    public boolean hasCaptain(){
        return this.captain != null;
    }

    public boolean hasPilot(){
        return this.pilot != null;
    }
}
