package com.springboot.ecommerce.service;

import java.util.List;

import com.springboot.ecommerce.model.Product;

public interface ProductService {
  public List<Product> getAllProducts();

  public Product getProduct(Long id);

  public Product createProduct(Product product);

  public Product updateProduct(Long id, Product product);

  public void deleteProduct(Long id);
}
