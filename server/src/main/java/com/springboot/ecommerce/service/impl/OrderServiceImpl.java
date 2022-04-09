package com.springboot.ecommerce.service.impl;

import java.util.List;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Order;
import com.springboot.ecommerce.repository.OrderRepository;
import com.springboot.ecommerce.service.OrderService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;

  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  public Order getOrder(Long id) {
    return orderRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
  }

  public Order createOrder(Order order) {
    return orderRepository.save(order);
  }

  public Order updateOrder(Long id, Order order) {
    orderRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
    order.setId(id);
    return orderRepository.save(order);
  }

  public void deleteOrder(Long id) {
    orderRepository.deleteById(id);
  }

}
