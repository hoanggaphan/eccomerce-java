package com.springboot.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.springboot.ecommerce.model.EmbeddedId.SkuAttributeId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sku_attribute")
public class SkuAttribute {
  @EmbeddedId
  private SkuAttributeId skuAttributeKeyId;

  @ManyToOne(cascade = CascadeType.ALL)
  @MapsId("skuId")
  @JoinColumn(name = "sku_id")
  private Sku sku;

  @ManyToOne(cascade = CascadeType.ALL)
  @MapsId("attributeId")
  @JoinColumn(name = "attribute_id")
  private Attribute attribute;

  @NotBlank(message = "field.notBlank")
  @Size(max = 50, message = "string.maxSize50")
  @Column(length = 50, nullable = false)
  private String value;
}
