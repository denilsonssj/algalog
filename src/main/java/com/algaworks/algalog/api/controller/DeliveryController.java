package com.algaworks.algalog.api.controller;

import org.modelmapper.ModelMapper;
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

import com.algaworks.algalog.api.assembler.DeliveryAssembler;
import com.algaworks.algalog.api.dto.DeliveryDto;
import com.algaworks.algalog.api.dto.DeliveryInputDto;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.service.DeliveryService;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

  private DeliveryService deliveryService;
  private DeliveryAssembler deliveryAssembler;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public DeliveryDto request(@Valid @RequestBody DeliveryInputDto deliveryInputDto) {
    Delivery newDelivery = deliveryAssembler.toEntity(deliveryInputDto);
    Delivery requestedDelivery = deliveryService.claim(newDelivery);
    return deliveryAssembler.toModel(requestedDelivery);
  }

  @GetMapping
  public List<DeliveryDto> list() {
    return deliveryAssembler.toColletionModel(deliveryService.list());
  }

  @GetMapping("{deliveryId}")
  public ResponseEntity<DeliveryDto> findOne(@PathVariable UUID deliveryId) {
    return deliveryService.findById(deliveryId)
      .map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
      .orElse(ResponseEntity.notFound().build());
  }

}
