package com.patskevich.planetexpress.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShipDto {

    private String name;
    private String species;
    private String color;
    private String captain;
    private String pilot;
}
