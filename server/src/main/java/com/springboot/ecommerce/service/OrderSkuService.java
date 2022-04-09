package com.springboot.ecommerce.service;

import java.util.List;

import com.springboot.ecommerce.model.OrderSku;

public interface OrderSkuService {
  public List<OrderSku> getAllOrderSkus();

  public OrderSku getOrderSku(Long id);

  public OrderSku createOrderSku(OrderSku orderSku);

  public OrderSku updateOrderSku(Long id, OrderSku prderSku);

  public void deleteOrderSku(Long id);
}
