package com.algaworks.algalog.api.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerIdInput {
  
  @NotNull
  private UUID id;

}
