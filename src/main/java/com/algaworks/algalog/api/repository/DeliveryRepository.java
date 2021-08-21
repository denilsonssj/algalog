package com.algaworks.algalog.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {}
