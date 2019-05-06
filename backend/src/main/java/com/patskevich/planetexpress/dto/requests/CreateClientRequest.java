package com.patskevich.planetexpress.dto.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CreateClientRequest {

    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private String name;
}
