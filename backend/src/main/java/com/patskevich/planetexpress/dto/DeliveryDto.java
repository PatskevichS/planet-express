package com.patskevich.planetexpress.dto;

import com.patskevich.planetexpress.utils.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveryDto {

    private long id;
    private String sender;
    private String recipient;
    private String planet;
    private String address;
    private String note;
    private String deliveryShip;
    private Status status;
    private String comment;
}
