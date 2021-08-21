package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.algaworks.algalog.domain.ValidationGroups;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Valid
  @ConvertGroup(from = Default.class, to = ValidationGroups.CustomerId.class)
  @NotNull
  @ManyToOne
  private Customer customer;

  @Valid
  @NotNull
  @Embedded
  private Addressee addressee;

  @NotNull
  private BigDecimal rate;

  @JsonProperty(access = Access.READ_ONLY)
  @Enumerated(EnumType.STRING)
  private StatusDelivery status;

  @JsonProperty(access = Access.READ_ONLY)
  private OffsetDateTime deliveryDate;

  @JsonProperty(access = Access.READ_ONLY)
  private OffsetDateTime finishedDate;

}
