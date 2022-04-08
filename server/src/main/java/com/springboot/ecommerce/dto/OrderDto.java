package com.springboot.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.ecommerce.domain.Status;
import com.springboot.ecommerce.model.OrderSku;

import lombok.Data;

@Data
public class OrderDto {
  private Long id;

  @NotBlank(message = "{field.notBlank}")
  private double shipCost;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime orderDateTime;

  private Status status = Status.pending;

  private Collection<OrderSku> orderItems;
}
