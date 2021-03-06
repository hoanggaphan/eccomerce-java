package com.springboot.ecommerce.model.EmbeddedId;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class OrderSkuId implements Serializable {
  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "sku_id")
  private Long skuId;
}