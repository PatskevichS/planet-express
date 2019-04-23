package com.patskevich.planetexpress.dto.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateDeliveryRequest {
    private String sender;
    private String recipient;
    private String planet;
    private String address;
    private String note;
}
