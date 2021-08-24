package com.algaworks.algalog.api.dto;

import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryInputDto {

  @Valid
  @NotNull
  private CustomerIdInput customer;

  @Valid
  @NotNull
  private AddresseeInput addressee;

  private BigDecimal rate;

}
