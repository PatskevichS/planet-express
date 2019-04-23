package com.patskevich.planetexpress.service;

import com.patskevich.planetexpress.converter.DeliveryConverter;
import com.patskevich.planetexpress.converter.EmployeeConverter;
import com.patskevich.planetexpress.dto.DeliveryDto;
import com.patskevich.planetexpress.dto.EmployeeDto;
import com.patskevich.planetexpress.dto.requests.CreateDeliveryRequest;
import com.patskevich.planetexpress.entity.Delivery;
import com.patskevich.planetexpress.repository.DeliveryRepository;
import com.patskevich.planetexpress.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryConverter deliveryConverter;

    public List<DeliveryDto> getDeliveryList() {
        return deliveryRepository.findAll().stream().map(deliveryConverter::convertToDto).collect(Collectors.toList());
    }

    public void createDelivery(CreateDeliveryRequest request) {
        Delivery delivery = new Delivery();
        delivery.setSender(request.getSender());
        delivery.setRecipient(request.getRecipient());
        delivery.setPlanet(request.getPlanet());
        delivery.setAddress(request.getAddress());
        delivery.setNote(request.getNote());
        delivery.setStatus("Pending"); // TODO enum
        deliveryRepository.save(delivery);
    }
}