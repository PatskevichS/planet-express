package com.patskevich.planetexpress.converter;

import com.patskevich.planetexpress.dto.DeliveryDto;
import com.patskevich.planetexpress.entity.Delivery;
import com.patskevich.planetexpress.entity.Ship;
import com.patskevich.planetexpress.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryConverter implements IDtoEntityConverter<DeliveryDto, Delivery> {

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private ShipConverter shipConverter;

    public DeliveryDto convertToDto(final Delivery delivery) {
        final DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setSender(delivery.getSender());
        deliveryDto.setRecipient(delivery.getRecipient());
        deliveryDto.setPlanet(delivery.getPlanet());
        deliveryDto.setAddress(delivery.getAddress());
        deliveryDto.setNote(delivery.getNote());
        setShipToDto(deliveryDto, delivery);
        deliveryDto.setStatus(delivery.getStatus()); // TODO enum
        return deliveryDto;
    }

    public Delivery convertToEntity(final DeliveryDto deliveryDto) {
        final Delivery delivery = new Delivery();
        delivery.setSender(deliveryDto.getSender());
        delivery.setRecipient(deliveryDto.getRecipient());
        delivery.setPlanet(deliveryDto.getPlanet());
        delivery.setAddress(deliveryDto.getAddress());
        delivery.setNote(deliveryDto.getNote());
        setShipToEntity(delivery, deliveryDto);
        delivery.setStatus(deliveryDto.getStatus()); // TODO enum
        return delivery;
    }

    private void setShipToDto(final DeliveryDto deliveryDto, final Delivery delivery) {
        if (delivery.getDeliveryShip() != null) {
            Optional<Ship> shipFromStore = shipRepository.findById(delivery.getDeliveryShip());
            deliveryDto.setDeliveryShip(shipConverter.convertToDto(shipFromStore.orElse(null)));
        }
    }

    private void setShipToEntity(final Delivery delivery, final DeliveryDto deliveryDto) {
        if (deliveryDto.ifDeliveryShipExist()) {
            // TODO something
        } else {
            delivery.setDeliveryShip(null);
        }
    }
}