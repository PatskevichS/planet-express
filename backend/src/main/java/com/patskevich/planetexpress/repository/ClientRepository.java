package com.patskevich.planetexpress.repository;

import com.patskevich.planetexpress.entity.Client;
import com.patskevich.planetexpress.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
