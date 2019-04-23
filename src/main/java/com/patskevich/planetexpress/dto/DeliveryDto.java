package com.patskevich.planetexpress.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveryDto {

    private String sender;
    private String recipient;
    private String planet;
    private String address;
    private String note;
    private ShipDto deliveryShip;
    private String Status;

    public boolean ifDeliveryShipExist() {
        return deliveryShip != null;
    }
}
