package com.springboot.ecommerce.dto;

import java.util.Collection;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class ProductDto {
  private Long id;

  @NotBlank(message = "{field.notBlank}")
  @Size(max = 100, message = "{string.maxSize100}")
  private String name;

  @NotBlank(message = "{field.notBlank}")
  @Size(max = 100, message = "{string.maxSize100}")
  private String slug;

  private String description;

  @NotNull(message = "{field.notBlank}")
  private Boolean active;
  
  private CategoryDto category;

  @JsonIgnoreProperties("product")
  private Collection<SkuDto> skus;

  private Collection<ImageDto> images;
}
