package com.springboot.ecommerce.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ImageDto {
  @NotBlank(message = "{field.notBlank}")
  @Size(max = 2000, message = "{string.maxSize2000}")
  private String src;
}
