package com.springboot.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.springboot.ecommerce.dto.ImageDto;
import com.springboot.ecommerce.model.Image;
import com.springboot.ecommerce.service.ImageService;

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
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {
  private final ImageService imageService;
  private final ModelMapper modelMapper;

  @GetMapping()
  public List<ImageDto> getAllUsers() {
    return imageService.getAllImages().stream()
        .map(Image -> modelMapper.map(Image, ImageDto.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public ImageDto getUser(@PathVariable("id") Long id) {
    return modelMapper.map(imageService.getImage(id), ImageDto.class);
  }

  @PostMapping()
  public ResponseEntity<ImageDto> createUser(@Valid @RequestBody ImageDto imageDto) {
    // convert DTO to entity
    Image imageReq = modelMapper.map(imageDto, Image.class);

    Image image = imageService.createImage(imageReq);

    // convert entity to DTO
    ImageDto imageRes = modelMapper.map(image, ImageDto.class);
    return new ResponseEntity<ImageDto>(imageRes, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ImageDto> updateUser(@PathVariable("id") Long id, @Valid @RequestBody ImageDto imageDto) {
    // convert DTO to entity
    Image imageReq = modelMapper.map(imageDto, Image.class);

    Image image = imageService.updateImage(id, imageReq);

    // convert entity to DTO
    ImageDto imageRes = modelMapper.map(image, ImageDto.class);
    return new ResponseEntity<ImageDto>(imageRes, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") Long id) {
    imageService.deleteImage(id);
  }
}
