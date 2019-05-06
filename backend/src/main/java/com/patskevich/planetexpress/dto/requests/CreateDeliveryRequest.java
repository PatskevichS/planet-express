package com.patskevich.planetexpress.dto.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CreateDeliveryRequest {

    @NotNull
    private long senderId;
    @NotNull
    private String recipient;
    @NotNull
    private String planet;
    @NotNull
    private String address;
    private String note;
}
