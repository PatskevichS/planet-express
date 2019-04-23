package com.patskevich.planetexpress.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {

    private String name;
    private int age;
    private String gender;
    private String species;
    private String planet;
    private ShipDto ship;
    private String profession;

    public boolean ifShipExist() {
        return ship != null;
    }
}
