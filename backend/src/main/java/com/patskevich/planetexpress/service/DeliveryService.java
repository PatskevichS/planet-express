package com.patskevich.planetexpress.service;

import com.patskevich.planetexpress.converter.DeliveryConverter;
import com.patskevich.planetexpress.utils.Comment;
import com.patskevich.planetexpress.dto.DeliveryDto;
import com.patskevich.planetexpress.utils.Status;
import com.patskevich.planetexpress.dto.requests.CreateDeliveryRequest;
import com.patskevich.planetexpress.entity.Client;
import com.patskevich.planetexpress.entity.Delivery;
import com.patskevich.planetexpress.entity.Ship;
import com.patskevich.planetexpress.exception.impl.DeliveryException;
import com.patskevich.planetexpress.exception.InternalServerException;
import com.patskevich.planetexpress.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeliveryService {
    // SERVICES
    private final ClientService clientService;
    private final ShipService shipService;
    // REPOSITORIES
    private final DeliveryRepository deliveryRepository;
    // CONVERTERS
    private final DeliveryConverter deliveryConverter;

    public List<DeliveryDto> getDeliveryList() {
        return deliveryRepository.findAll().stream()
                .map(this::convertAndUpdateStatus).collect(Collectors.toList());
    }

    public List<DeliveryDto> getDeliveryListForClient(final long clientId) {
        return deliveryRepository.findAllBySenderIdOrderByIdDesc(clientId)
                .stream().map(deliveryConverter::convertToDto).collect(Collectors.toList());
    }

    public List<DeliveryDto> getDeliveryListByStatus(final String status) {
        return deliveryRepository.findAllByStatusOrderByIdDesc(status)
                .stream().map(deliveryConverter::convertToDto).collect(Collectors.toList());
    }

    public List<DeliveryDto> getDeliveryListByStatusForClient(final String status,final long clientId) {
        return deliveryRepository.findAllByStatusAndSenderIdOrderByIdDesc(status,clientId)
                .stream().map(deliveryConverter::convertToDto).collect(Collectors.toList());
    }

    public void acceptToDelivering(final long deliveryId, final long shipID) throws InternalServerException {
        final Delivery delivery = findDelivery(deliveryId);
        final Ship ship = shipService.findShip(shipID);
        shipService.validateShip(ship);
        Status.setInTransitStatus(delivery);
        delivery.setDeliveryShip(ship.getId());
        delivery.setComment(Comment.TRANSIT);
        deliveryRepository.save(delivery);
    }

    public void doneDelivering(final long deliveryId) throws InternalServerException {
        final Delivery delivery = findDelivery(deliveryId);
        Status.setDeliveredStatus(delivery);
        delivery.setComment(Comment.DELIVERED);
        deliveryRepository.save(delivery);
    }

    public void createDelivery(final CreateDeliveryRequest request) throws InternalServerException {
        final Client client = clientService.findClient(request.getSenderId());
        final Delivery delivery = new Delivery();
        delivery.setSenderId(client.getId());
        delivery.setRecipient(request.getRecipient());
        delivery.setPlanet(request.getPlanet());
        delivery.setAddress(request.getAddress());
        delivery.setNote(request.getNote());
        Status.setPendingStatus(delivery);
        delivery.setComment(Comment.PENDING);
        deliveryRepository.save(delivery);
    }

    public Delivery findDelivery(final long id) throws DeliveryException {
        final Delivery delivery = deliveryRepository.findById(id).orElse(null);
        if (delivery == null) {
            throw new DeliveryException("Error. Ship does not exist!");
        } else {
            return delivery;
        }
    }

    private DeliveryDto convertAndUpdateStatus(final Delivery delivery){
        if (delivery.getStatus().equals(Status.Pending.toString())) {
            Status.setInfoReceivedStatus(delivery);
            delivery.setComment(Comment.INFO_RECEIVED);
            deliveryRepository.save(delivery);
        }
        return deliveryConverter.convertToDto(delivery);
    }
}