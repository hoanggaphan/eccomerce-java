package com.springboot.ecommerce.service;

import java.util.List;

import com.springboot.ecommerce.model.Category;

public interface CategoryService {
  public List<Category> getAllCategories();

  public Category getCategory(Long id);

  public Category createCategory(Category category);

  public Category updateCategory(Long id, Category category);

  public void deleteCategory(Long id);
}
