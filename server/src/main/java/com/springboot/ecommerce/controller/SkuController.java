package com.springboot.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.springboot.ecommerce.dto.SkuDto;
import com.springboot.ecommerce.model.Sku;
import com.springboot.ecommerce.service.SkuService;

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
@RequestMapping("/api/v1/skus")
@RequiredArgsConstructor
public class SkuController {
  private final SkuService skuService;
  private final ModelMapper modelMapper;

  @GetMapping()
  public List<SkuDto> getAllUsers() {
    return skuService.getAllSkus()
        .stream()
        .map(sku -> modelMapper.map(sku, SkuDto.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public SkuDto getUser(@PathVariable("id") Long id) {
    return modelMapper.map(skuService.getSku(id), SkuDto.class);
  }

  @PostMapping()
  public ResponseEntity<SkuDto> createUser(@Valid @RequestBody SkuDto skuDto) {
    // convert DTO to entity
    Sku skuReq = modelMapper.map(skuDto, Sku.class);

    Sku sku = skuService.createSku(skuReq);

    // convert entity to DTO
    SkuDto skuRes = modelMapper.map(sku, SkuDto.class);
    return new ResponseEntity<SkuDto>(skuRes, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SkuDto> updateUser(@PathVariable("id") Long id, @Valid @RequestBody SkuDto skuDto) {
    // convert DTO to entity
    Sku skuReq = modelMapper.map(skuDto, Sku.class);

    Sku sku = skuService.updateSku(id, skuReq);

    // convert entity to DTO
    SkuDto skuRes = modelMapper.map(sku, SkuDto.class);
    return new ResponseEntity<SkuDto>(skuRes, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") Long id) {
    skuService.deleteSku(id);
  }
}
