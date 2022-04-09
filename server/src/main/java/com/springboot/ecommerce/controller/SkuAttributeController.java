package com.springboot.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.springboot.ecommerce.dto.SkuAttributeDto;
import com.springboot.ecommerce.model.SkuAttribute;
import com.springboot.ecommerce.service.SkuAttributeService;

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
@RequestMapping("/api/v1/sku-attribute")
@RequiredArgsConstructor
public class SkuAttributeController {
  private final SkuAttributeService skuAttributeService;
  private final ModelMapper modelMapper;

  @GetMapping()
  public List<SkuAttributeDto> getAllSkuAttributes() {
    return skuAttributeService.getAllSkuAttributes().stream()
        .map(skuAttribute -> modelMapper.map(skuAttribute, SkuAttributeDto.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public SkuAttributeDto getSkuAttribute(@PathVariable("id") Long id) {
    return modelMapper.map(skuAttributeService.getSkuAttribute(id), SkuAttributeDto.class);
  }

  @PostMapping()
  public ResponseEntity<SkuAttributeDto> createSkuAttribute(@Valid @RequestBody SkuAttributeDto skuAttributeDto) {
    // convert DTO to entity
    SkuAttribute skuAttributeReq = modelMapper.map(skuAttributeDto, SkuAttribute.class);

    SkuAttribute skuAttribute = skuAttributeService.createSkuAttribute(skuAttributeReq);

    // convert entity to DTO
    SkuAttributeDto skuAttributeRes = modelMapper.map(skuAttribute, SkuAttributeDto.class);
    return new ResponseEntity<SkuAttributeDto>(skuAttributeRes, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SkuAttributeDto> updateSkuAttribute(@PathVariable("id") Long id,
      @Valid @RequestBody SkuAttributeDto skuAttributeDto) {
    // convert DTO to entity
    SkuAttribute skuAttributeReq = modelMapper.map(skuAttributeDto, SkuAttribute.class);

    SkuAttribute skuAttribute = skuAttributeService.updateSkuAttribute(id, skuAttributeReq);

    // convert entity to DTO
    SkuAttributeDto skuAttributeRes = modelMapper.map(skuAttribute, SkuAttributeDto.class);
    return new ResponseEntity<SkuAttributeDto>(skuAttributeRes, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteSkuAttribute(@PathVariable("id") Long id) {
    skuAttributeService.deleteSkuAttribute(id);
  }
}
