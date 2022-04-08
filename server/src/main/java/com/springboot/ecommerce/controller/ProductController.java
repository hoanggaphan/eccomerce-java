package com.springboot.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.springboot.ecommerce.dto.ProductDto;
import com.springboot.ecommerce.model.Product;
import com.springboot.ecommerce.service.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;
  private final ModelMapper modelMapper;

  @GetMapping()
  public List<ProductDto> getAllUsers() {
    return productService.getAllProducts().stream()
        .map(product -> modelMapper.map(product, ProductDto.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public ProductDto getUser(@PathVariable("id") Long id) {
    return modelMapper.map(productService.getProduct(id), ProductDto.class);
  }

  @PostMapping()
  public ResponseEntity<ProductDto> createUser(@Valid @RequestBody ProductDto productDto) {
    // convert DTO to entity
    Product productReq = modelMapper.map(productDto, Product.class);

    Product product = productService.createProduct(productReq);

    // convert entity to DTO
    ProductDto productRes = modelMapper.map(product, ProductDto.class);
    return new ResponseEntity<ProductDto>(productRes, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductDto> updateUser(@PathVariable("id") Long id, @Valid @RequestBody ProductDto productDto) {
    // convert DTO to entity
    Product productReq = modelMapper.map(productDto, Product.class);

    Product product = productService.updateProduct(id, productReq);

    // convert entity to DTO
    ProductDto productRes = modelMapper.map(product, ProductDto.class);
    return new ResponseEntity<ProductDto>(productRes, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") Long id) {
    productService.deleteProduct(id);
  }

}
