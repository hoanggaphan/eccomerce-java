package com.springboot.ecommerce.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.springboot.ecommerce.key.SkuAttributeKey;

import lombok.Data;

@Data
public class SkuAttributeDto {
  private SkuAttributeKey id;

  @NotBlank(message = "field.notBlank")
  @Size(max = 50, message = "string.maxSize50")
  private String value;

}
