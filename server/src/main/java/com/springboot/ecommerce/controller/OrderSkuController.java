package com.springboot.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.springboot.ecommerce.dto.OrderSkuDto;
import com.springboot.ecommerce.model.OrderSku;
import com.springboot.ecommerce.service.OrderSkuService;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order-sku")
@RequiredArgsConstructor
public class OrderSkuController {
  private final OrderSkuService orderSkuService;
  private final ModelMapper modelMapper;

  @GetMapping()
  public List<OrderSkuDto> getAllOrderSkus() {
    return orderSkuService.getAllOrderSkus().stream()
        .map(orderSkuDto -> modelMapper.map(orderSkuDto, OrderSkuDto.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public OrderSkuDto getOrderSku(@PathVariable("id") Long id) {
    return modelMapper.map(orderSkuService.getOrderSku(id), OrderSkuDto.class);
  }

  @PostMapping()
  public ResponseEntity<OrderSkuDto> createOrderSku(@Valid @RequestBody OrderSkuDto orderSkuDto) {
    // convert DTO to entity
    OrderSku orderSkuReq = modelMapper.map(orderSkuDto, OrderSku.class);

    OrderSku orderSku = orderSkuService.createOrderSku(orderSkuReq);

    // convert entity to DTO
    OrderSkuDto orderSkuRes = modelMapper.map(orderSku, OrderSkuDto.class);
    return new ResponseEntity<OrderSkuDto>(orderSkuRes, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<OrderSkuDto> updateOrderSku(@PathVariable("id") Long id,
      @Valid @RequestBody OrderSkuDto orderSkuDto) {
    // convert DTO to entity
    OrderSku orderSkuReq = modelMapper.map(orderSkuDto, OrderSku.class);

    OrderSku orderSku = orderSkuService.updateOrderSku(id, orderSkuReq);

    // convert entity to DTO
    OrderSkuDto orderSkuRes = modelMapper.map(orderSku, OrderSkuDto.class);
    return new ResponseEntity<OrderSkuDto>(orderSkuRes, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteOrderSku(@PathVariable("id") Long id) {
    orderSkuService.deleteOrderSku(id);
  }
}
