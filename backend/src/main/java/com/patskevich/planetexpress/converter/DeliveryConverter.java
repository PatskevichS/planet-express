package com.patskevich.planetexpress.converter;

import com.patskevich.planetexpress.dto.DeliveryDto;
import com.patskevich.planetexpress.entity.Delivery;
import com.patskevich.planetexpress.repository.ClientRepository;
import com.patskevich.planetexpress.repository.ShipRepository;
import com.patskevich.planetexpress.utils.IdWriter;
import com.patskevich.planetexpress.utils.Status;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@AllArgsConstructor
public class DeliveryConverter implements IDtoEntityConverter<DeliveryDto, Delivery> {
    // REPOSITORIES
    private ShipRepository shipRepository;
    private ClientRepository clientRepository;

    public DeliveryDto convertToDto(final Delivery delivery) {
        final DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setSender(IdWriter.write(delivery.getSenderId(),
                clientRepository.getOne(delivery.getSenderId()).getName()));
        setShipToDto(deliveryDto, delivery);
        deliveryDto.setStatus(Status.valueOf(delivery.getStatus()));
        BeanUtils.copyProperties(delivery, deliveryDto, "sender", "deliveryShip", "status");
        return deliveryDto;
    }

    public Delivery convertToEntity(final DeliveryDto deliveryDto) {
        Assert.isTrue(false, "This shall never happen");
        return null;
    }

    private void setShipToDto(final DeliveryDto deliveryDto, final Delivery delivery) {
        if (delivery.getDeliveryShip() != null) {
            deliveryDto.setDeliveryShip(IdWriter.write(delivery.getDeliveryShip(),
                    shipRepository.getOne(delivery.getDeliveryShip()).getName()));
        }
    }
}