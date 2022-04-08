package com.springboot.ecommerce.service;

import java.util.List;

import com.springboot.ecommerce.model.Sku;

public interface SkuService {
  public List<Sku> getAllSkus();

  public Sku getSku(Long id);

  public Sku createSku(Sku sku);

  public Sku updateSku(Long id, Sku sku);

  public void deleteSku(Long id);
}
