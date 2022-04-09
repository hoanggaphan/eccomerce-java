package com.springboot.ecommerce.dto;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class SkuDto {
  private Long id;

  @NotNull(message = "{field.notBlank}")
  private int qty;

  @NotNull(message = "{field.notBlank}")
  private double basePrice;

  @JsonIgnoreProperties("skus")
  private ProductDto product;

  private Collection<SkuAttributeDto> variants;
}
