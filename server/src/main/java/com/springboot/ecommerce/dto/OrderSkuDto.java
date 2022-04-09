package com.springboot.ecommerce.dto;

import javax.validation.constraints.NotNull;

import com.springboot.ecommerce.key.OrderSkuKey;

import lombok.Data;

@Data
public class OrderSkuDto {
  private OrderSkuKey id;

  @NotNull(message = "field.notBlank")
  private int qty;

  @NotNull(message = "field.notBlank")
  private double orderedPrice;
}
