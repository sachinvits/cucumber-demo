package com.sapient.cucumber.service;

import java.util.List;
import com.sapient.cucumber.entity.User;

public interface UserService {
  Integer addUser(User user);

  List<User> findAll();

  User findById(Integer id);

  Integer updateUser(User user);
}
