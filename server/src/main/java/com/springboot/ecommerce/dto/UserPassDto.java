package com.springboot.ecommerce.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserPassDto {
  @NotBlank(message = "{field.notBlank}")
  @Size(max = 32, message = "{string.maxSize32}")
  @Column(length = 32, nullable = false, unique = true)
  private String account;

  @NotBlank(message = "{field.notBlank}")
  @Size(max = 32, message = "{string.maxSize32}")
  @Column(length = 32, nullable = false)
  private String password;
}
