package com.patskevich.planetexpress.repository;

import com.patskevich.planetexpress.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
}
