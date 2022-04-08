package com.springboot.ecommerce.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderSkuKey implements Serializable {
  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "sku_id")
  private Long skuId;
}