package com.algaworks.algalog.api.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

  List<Customer> findByName(String name);

}
