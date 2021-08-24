package com.algaworks.algalog.api.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddresseeInput {

  @NotBlank
  private String name;

  @NotBlank
  private String street;

  @NotBlank
  private String number;

  @NotBlank
  private String complement;

  @NotBlank
  private String district;

}
