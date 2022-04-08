package com.springboot.ecommerce.service.impl;

import java.util.List;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Attribute;
import com.springboot.ecommerce.repository.AttributeRepository;
import com.springboot.ecommerce.service.AttributeService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {
  private final AttributeRepository attributeRepository;

  public List<Attribute> getAllAttributes() {
    return attributeRepository.findAll();
  }

  public Attribute getAttribute(Long id) {
    return attributeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Attribute", "Id", id));
  }

  public Attribute createAttribute(Attribute attribute) {
    return attributeRepository.save(attribute);
  }

  public Attribute updateAttribute(Long id, Attribute attribute) {
    attributeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Attribute", "id", id));
    attribute.setId(id);
    return attributeRepository.save(attribute);
  }

  public void deleteAttribute(Long id) {
    attributeRepository.deleteById(id);
  }
}
