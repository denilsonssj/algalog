package com.algaworks.algalog.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.service.DeliveryService;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

  private DeliveryService deliveryService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Delivery claim(@Valid @RequestBody Delivery delivery) {
    return deliveryService.claim(delivery);
  }

  @GetMapping
  public List<Delivery> list() {
    return deliveryService.list();
  }

  @GetMapping("{deliveryId}")
  public ResponseEntity<Delivery> findOne(@PathVariable UUID deliveryId) {
    return deliveryService.findById(deliveryId)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

}
