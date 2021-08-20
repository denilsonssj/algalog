package com.algaworks.algalog.api.controller;

import java.util.List;
import java.util.UUID;

import com.algaworks.algalog.api.repository.CustomerRepository;
import com.algaworks.algalog.domain.model.Customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

  private CustomerRepository customerRepository;

  @GetMapping
  public List<Customer> list() {
    return customerRepository.findAll();
  }

  @GetMapping("/{clientId}")
  public ResponseEntity<Customer> getCustomer(@PathVariable UUID clientId) {
    return customerRepository.findById(clientId)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerRepository.save(customer);
  }

  @PutMapping("/{clientId}")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Customer> updateCustomer(@PathVariable UUID clientId, 
      @RequestBody Customer customer) {
        if (!customerRepository.existsById(clientId)) {
          return ResponseEntity.notFound().build();
        }
        customer.setId(clientId);
        customer = customerRepository.save(customer);
        return ResponseEntity.ok(customer);
  }

  @DeleteMapping("/{clientId}")
  public ResponseEntity<Void> delete(@PathVariable UUID clientId) {
    if (!customerRepository.existsById(clientId)) {
      return ResponseEntity.notFound().build();
    }
    customerRepository.deleteById(clientId);
    return ResponseEntity.noContent().build();
  }
  
}
