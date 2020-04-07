package com.sapient.cucumber.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sapient.cucumber.entity.User;
import com.sapient.cucumber.repository.UserRepository;
import com.sapient.cucumber.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public Integer addUser(final User user) {
    final User savedUser = userRepository.save(user);

    return savedUser.getId();
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findById(final Integer id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException(String.format("User not for id: %d", id)));
  }

  @Override
  public Integer updateUser(final User user) {
    final User savedUser = findById(user.getId());

    savedUser.setEmail(user.getEmail());
    savedUser.setFirstName(user.getFirstName());
    savedUser.setLastName(user.getLastName());
    savedUser.setUserName(user.getUserName());

    return userRepository.save(savedUser).getId();
  }

}
