package com.springboot.ecommerce.service;

import java.util.List;

import com.springboot.ecommerce.model.Image;

public interface ImageService {
  public List<Image> getAllImages();

  public Image getImage(Long id);

  public Image createImage(Image image);

  public Image updateImage(Long id, Image image);

  public void deleteImage(Long id);
}
