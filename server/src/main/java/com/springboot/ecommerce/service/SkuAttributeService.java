package com.springboot.ecommerce.service;

import java.util.List;

import com.springboot.ecommerce.model.SkuAttribute;

public interface SkuAttributeService {
  public List<SkuAttribute> getAllSkuAttributes();

  public SkuAttribute getSkuAttribute(Long id);

  public SkuAttribute createSkuAttribute(SkuAttribute skuAttribute);

  public SkuAttribute updateSkuAttribute(Long id, SkuAttribute skuAttribute);

  public void deleteSkuAttribute(Long id);
}
