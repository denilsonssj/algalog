package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Embedded
  private Addressee addressee;

  private BigDecimal rate;

  @JsonProperty(access = Access.READ_ONLY)
  @Enumerated(EnumType.STRING)
  private StatusDelivery status;

  @JsonProperty(access = Access.READ_ONLY)
  private LocalDateTime deliveryDate;

  @JsonProperty(access = Access.READ_ONLY)
  private LocalDateTime finishedDate;

}
