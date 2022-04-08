package com.springboot.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.springboot.ecommerce.key.OrderSkuKey;

@Entity
@Table(name = "order_sku")
public class OrderSku {
  @EmbeddedId
  private OrderSkuKey id;

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @MapsId("skuId")
  @JoinColumn(name = "sku_id")
  private Sku sku;

  @NotBlank(message = "field.notBlank")
  @Column(nullable = false)
  private int qty;

  @NotBlank(message = "field.notBlank")
  @Column(name = "ordered_price", nullable = false)
  private double orderedPrice;
}
