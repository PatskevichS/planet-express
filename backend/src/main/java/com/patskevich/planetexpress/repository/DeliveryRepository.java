package com.patskevich.planetexpress.repository;

import com.patskevich.planetexpress.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findAllBySenderIdOrderByIdDesc(final long clientId);
    List<Delivery> findAllByStatusOrderByIdDesc(final String status);
    List<Delivery> findAllByStatusAndSenderIdOrderByIdDesc(final String status, final long clientId);
}
