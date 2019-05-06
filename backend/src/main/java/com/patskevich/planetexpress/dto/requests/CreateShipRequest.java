package com.patskevich.planetexpress.dto.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CreateShipRequest {

    @NotNull
    private String name;
    private String species;
    private String color;
}
