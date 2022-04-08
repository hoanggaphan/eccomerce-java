package com.springboot.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.springboot.ecommerce.dto.CategoryDto;
import com.springboot.ecommerce.model.Category;
import com.springboot.ecommerce.service.CategoryService;

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
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
  private final CategoryService CategoryService;
  private final ModelMapper modelMapper;

  @GetMapping()
  public List<CategoryDto> getAllCategorys() {
    return CategoryService.getAllCategories().stream()
        .map(Category -> modelMapper.map(Category, CategoryDto.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public CategoryDto getCategory(@PathVariable("id") Long id) {
    return modelMapper.map(CategoryService.getCategory(id), CategoryDto.class);
  }

  @PostMapping()
  public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
    // convert DTO to entity
    Category categoryReq = modelMapper.map(categoryDto, Category.class);

    Category category = CategoryService.createCategory(categoryReq);

    // convert entity to DTO
    CategoryDto categoryRes = modelMapper.map(category, CategoryDto.class);
    return new ResponseEntity<CategoryDto>(categoryRes, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long id,
      @Valid @RequestBody CategoryDto categoryDto) {
    // convert DTO to entity
    Category categoryReq = modelMapper.map(categoryDto, Category.class);

    Category category = CategoryService.updateCategory(id, categoryReq);

    // convert entity to DTO
    CategoryDto categoryRes = modelMapper.map(category, CategoryDto.class);
    return new ResponseEntity<CategoryDto>(categoryRes, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteCategory(@PathVariable("id") Long id) {
    CategoryService.deleteCategory(id);
  }
}
