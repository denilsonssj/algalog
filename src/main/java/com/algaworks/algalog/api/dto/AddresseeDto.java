package com.algaworks.algalog.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddresseeDto {
  private String name;
  private String street;
  private String number;
  private String complement;
  private String district;
}
