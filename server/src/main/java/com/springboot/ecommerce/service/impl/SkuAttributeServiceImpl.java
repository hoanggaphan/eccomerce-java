package com.springboot.ecommerce.service.impl;

import java.util.List;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Attribute;
import com.springboot.ecommerce.model.Sku;
import com.springboot.ecommerce.model.SkuAttribute;
import com.springboot.ecommerce.repository.SkuAttributeRepository;
import com.springboot.ecommerce.service.AttributeService;
import com.springboot.ecommerce.service.SkuAttributeService;
import com.springboot.ecommerce.service.SkuService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkuAttributeServiceImpl implements SkuAttributeService {
  private final SkuAttributeRepository skuAttributeRepository;
  private final SkuService skuService;
  private final AttributeService attributeService;

  public List<SkuAttribute> getAllSkuAttributes() {
    return skuAttributeRepository.findAll();
  }

  public SkuAttribute getSkuAttribute(Long id) {
    return skuAttributeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("SkuAttribute", "Id", id));
  }

  public SkuAttribute createSkuAttribute(SkuAttribute skuAttribute) {
    Sku sku = skuService.getSku(skuAttribute.getSku().getId());
    Attribute attribute = attributeService.getAttribute(skuAttribute.getAttribute().getId());

    skuAttribute.setSku(sku);
    skuAttribute.setAttribute(attribute);

    return skuAttributeRepository.save(skuAttribute);
  }

  public SkuAttribute updateSkuAttribute(Long id, SkuAttribute skuAttribute) {
    skuAttributeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("SkuAttribute", "id", id));
    // skuAttribute.setsetId(id);
    return skuAttributeRepository.save(skuAttribute);
  }

  public void deleteSkuAttribute(Long id) {
    skuAttributeRepository.deleteById(id);
  }
}
