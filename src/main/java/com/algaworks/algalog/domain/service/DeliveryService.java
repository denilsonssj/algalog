package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

import com.algaworks.algalog.domain.model.Customer;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.StatusDelivery;
import com.algaworks.algalog.api.repository.DeliveryRepository;

@AllArgsConstructor
@Service
public class DeliveryService {

  private DeliveryRepository deliveryRepository;
  private CustomerService customerService;
  
  @Transactional
  public Delivery claim(Delivery delivery) {
    Customer customer = customerService.search(delivery.getCustomer().getId());
    delivery.setCustomer(customer);
    delivery.setStatus(StatusDelivery.PENDING);
    delivery.setDeliveryDate(LocalDateTime.now());
    return deliveryRepository.save(delivery);
  }

}
