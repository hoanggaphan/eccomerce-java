package com.springboot.ecommerce.service.impl;

import java.util.List;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Sku;
import com.springboot.ecommerce.repository.SkuRepository;
import com.springboot.ecommerce.service.SkuService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkuServiceImpl implements SkuService {
  private final SkuRepository skuRepository;

  public List<Sku> getAllSkus() {
    return skuRepository.findAll();
  }

  public Sku getSku(Long id) {
    return skuRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Sku", "Id", id));
  }

  public Sku createSku(Sku Sku) {
    return skuRepository.save(Sku);
  }

  public Sku updateSku(Long id, Sku sku) {
    skuRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Sku", "id", id));
    sku.setId(id);
    return skuRepository.save(sku);
  }

  public void deleteSku(Long id) {
    skuRepository.deleteById(id);
  }
}
