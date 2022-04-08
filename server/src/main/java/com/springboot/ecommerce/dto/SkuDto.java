package com.springboot.ecommerce.dto;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.ecommerce.model.SkuAttribute;

import lombok.Data;

@Data
public class SkuDto {
  private Long id;
  private int qty;
  private double basePrice;

  @JsonIgnoreProperties("skus")
  private ProductDto product;

  private Collection<SkuAttribute> variants;
}
