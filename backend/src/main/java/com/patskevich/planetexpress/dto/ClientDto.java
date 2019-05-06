package com.patskevich.planetexpress.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ClientDto {

    @NotNull
    private String name;
}
