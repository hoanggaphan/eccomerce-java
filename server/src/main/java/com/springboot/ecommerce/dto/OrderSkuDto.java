package com.springboot.ecommerce.dto;

import javax.validation.constraints.NotNull;

import com.springboot.ecommerce.model.EmbeddedId.OrderSkuId;

import lombok.Data;

@Data
public class OrderSkuDto {
  private OrderSkuId id;

  @NotNull(message = "field.notBlank")
  private int qty;

  @NotNull(message = "field.notBlank")
  private double orderedPrice;
}
