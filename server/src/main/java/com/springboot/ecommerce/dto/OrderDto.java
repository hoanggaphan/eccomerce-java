package com.springboot.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.ecommerce.domain.Status;

import lombok.Data;

@Data
public class OrderDto {
  private Long id;

  @NotNull(message = "{field.notBlank}")
  private double shipCost;

  @NotNull(message = "{field.notBlank}")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime orderDateTime;

  @NotNull(message = "{field.notBlank}")
  private Status status = Status.pending;

  @NotNull(message = "{field.notBlank}")
  private UserDto user;

  private Collection<OrderSkuDto> orderItems;
}
