package com.springboot.ecommerce.service.impl;

import java.util.List;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Order;
import com.springboot.ecommerce.model.OrderSku;
import com.springboot.ecommerce.model.Sku;
import com.springboot.ecommerce.repository.OrderSkuRepository;
import com.springboot.ecommerce.service.OrderService;
import com.springboot.ecommerce.service.OrderSkuService;
import com.springboot.ecommerce.service.SkuService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderSkuServiceImpl implements OrderSkuService {
  private final OrderSkuRepository orderSkuRepository;
  private final OrderService orderService;
  private final SkuService skuService;

  public List<OrderSku> getAllOrderSkus() {
    return orderSkuRepository.findAll();
  }

  public OrderSku getOrderSku(Long id) {
    return orderSkuRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("OrderSku", "Id", id));
  }

  public OrderSku createOrderSku(OrderSku orderSku) {
    Order order = orderService.getOrder(orderSku.getOrder().getId());
    Sku sku = skuService.getSku(orderSku.getSku().getId());

    orderSku.setOrder(order);
    orderSku.setSku(sku);

    return orderSkuRepository.save(orderSku);
  }

  public OrderSku updateOrderSku(Long id, OrderSku OrderSku) {
    orderSkuRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("OrderSku", "id", id));
    // OrderSku.setsetId(id);
    return orderSkuRepository.save(OrderSku);
  }

  public void deleteOrderSku(Long id) {
    orderSkuRepository.deleteById(id);
  }
}
