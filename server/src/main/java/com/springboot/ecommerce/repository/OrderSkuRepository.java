package com.springboot.ecommerce.repository;

import com.springboot.ecommerce.model.OrderSku;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSkuRepository extends JpaRepository<OrderSku, Long> {

}
