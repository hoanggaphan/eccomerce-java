package com.springboot.ecommerce.service.impl;

import java.util.List;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Image;
import com.springboot.ecommerce.repository.ImageRepository;
import com.springboot.ecommerce.service.ImageService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
  private final ImageRepository imageRepository;

  public List<Image> getAllImages() {
    return imageRepository.findAll();
  }

  public Image getImage(Long id) {
    return imageRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Image", "Id", id));
  }

  public Image createImage(Image image) {
    return imageRepository.save(image);
  }

  public Image updateImage(Long id, Image image) {
    imageRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Image", "id", id));
    image.setId(id);
    return imageRepository.save(image);
  }

  public void deleteImage(Long id) {
    imageRepository.deleteById(id);
  }
}
