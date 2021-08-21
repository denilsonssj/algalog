package com.algaworks.algalog.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.service.DeliveryService;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

  private DeliveryService deliveryService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Delivery claim(@RequestBody Delivery delivery) {
    return deliveryService.claim(delivery);
  }

}
