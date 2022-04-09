package com.springboot.ecommerce.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class SkuAttributeKey implements Serializable {
  @Column(name = "sku_id")
  private Long skuId;

  @Column(name = "attribute_id")
  private Long attributeId;
}
