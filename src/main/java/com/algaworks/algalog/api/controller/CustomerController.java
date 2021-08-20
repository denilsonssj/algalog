package com.algaworks.algalog.api.controller;

import java.util.List;

import com.algaworks.algalog.api.repository.CustomerRepository;
import com.algaworks.algalog.domain.model.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

  private CustomerRepository customerRepository;

  @GetMapping()
  public List<Customer> list() {
    return customerRepository.findAll();
  }
  
}
