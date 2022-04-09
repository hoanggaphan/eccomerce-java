package com.springboot.ecommerce.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sku {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sku_id")
  private Long id;

  @NotNull(message = "{field.notBlank}")
  @Column(columnDefinition = "integer default 0", nullable = false)
  private int qty = 0;

  @NotNull(message = "{field.notBlank}")
  @Column(name = "base_price", columnDefinition = "double default 0", nullable = false)
  private double basePrice = 0;

  // Nhiều dạng sku thuộc 1 product.
  @NotNull(message = "{field.notBlank}")
  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false) // thông qua khóa ngoại product_id
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Product product;

  @OneToMany(mappedBy = "sku", cascade = CascadeType.ALL)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<SkuAttribute> variants;

  @OneToMany(mappedBy = "sku", cascade = CascadeType.ALL)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Collection<OrderSku> orderItems;
}
