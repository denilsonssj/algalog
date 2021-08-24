package com.algaworks.algalog.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

import com.algaworks.algalog.domain.model.StatusDelivery;

@Getter
@Setter
public class DeliveryDto {
  private UUID id;
  private CustomerDto customer;
  private AddresseeDto addressee;
  private BigDecimal rate;
  private StatusDelivery status;
  private OffsetDateTime deliveryDate;
  private OffsetDateTime finishedDate;
}
