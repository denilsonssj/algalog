package com.algaworks.algalog.domain.service;

import java.util.List;
import java.util.UUID;

import com.algaworks.algalog.api.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;

import com.algaworks.algalog.domain.exception.DomainException;
import com.algaworks.algalog.domain.model.Customer;

@AllArgsConstructor
@Service
public class CustomerService {

  private CustomerRepository customerRepository;

  @Transactional
  public Customer save(Customer customer) {
    boolean emailExists = customerRepository.findByEmail(customer.getEmail())
      .stream()
      .anyMatch(existingCustomer -> !existingCustomer.equals(customer));
    if (emailExists) {
      throw new DomainException("Já existe um cliente cadastrado com esse e-mail!");
    }
    return customerRepository.save(customer);
  }

  @Transactional
  public void delete(UUID clientId) {
    customerRepository.deleteById(clientId);
  }

  @Transactional
  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

}
