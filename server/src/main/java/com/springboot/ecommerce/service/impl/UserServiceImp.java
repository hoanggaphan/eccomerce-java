package com.springboot.ecommerce.service.impl;

import java.util.List;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.User;
import com.springboot.ecommerce.repository.UserRepository;
import com.springboot.ecommerce.service.UserService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
  private final UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUser(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(Long id, User user) {
    userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    user.setId(id);
    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

}
