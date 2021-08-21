package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    delivery.setDeliveryDate(OffsetDateTime.now());
    return deliveryRepository.save(delivery);
  }

  @Transactional
  public List<Delivery> list() {
    return deliveryRepository.findAll();
  }

  @Transactional
  public Optional<Delivery> findById(UUID id) {
    return deliveryRepository.findById(id);
  }

}
