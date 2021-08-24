package com.algaworks.algalog.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import com.algaworks.algalog.api.dto.DeliveryDto;
import com.algaworks.algalog.api.dto.DeliveryInputDto;
import com.algaworks.algalog.domain.model.Delivery;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

  private ModelMapper modelMapper;

  public DeliveryDto toModel(Delivery delivery) {
    return modelMapper.map(delivery, DeliveryDto.class);
  }

  public List<DeliveryDto> toColletionModel(List<Delivery> deliveries) {
    return deliveries.stream()
      .map(this::toModel)
      .collect(Collectors.toList());
  }

  public Delivery toEntity(DeliveryInputDto deliveryInputDto) {
    return modelMapper.map(deliveryInputDto, Delivery.class);
  }
  
}
