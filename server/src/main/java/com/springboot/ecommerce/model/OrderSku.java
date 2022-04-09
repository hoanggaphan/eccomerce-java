package com.springboot.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.springboot.ecommerce.key.OrderSkuKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_sku")
public class OrderSku {
  @EmbeddedId
  private OrderSkuKey id;

  @ManyToOne(cascade = CascadeType.ALL)
  @MapsId("orderId")
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne(cascade = CascadeType.ALL)
  @MapsId("skuId")
  @JoinColumn(name = "sku_id")
  private Sku sku;

  @NotNull(message = "field.notBlank")
  @Column(nullable = false)
  private int qty;

  @NotNull(message = "field.notBlank")
  @Column(name = "ordered_price", nullable = false)
  private double orderedPrice;
}
