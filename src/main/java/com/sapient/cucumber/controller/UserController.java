package com.sapient.cucumber.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.cucumber.entity.User;
import com.sapient.cucumber.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

  @Autowired
  private UserService userService;


  @RequestMapping(value = "/add", method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> addUser(@RequestBody final User user)
      throws Exception {

    final Integer id = userService.addUser(user);

    final Map<String, Object> status = new HashMap<>();
    status.put("status", String.format("User having id=%d, saved successfully", id));

    return new ResponseEntity<>(status, HttpStatus.OK);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> getAllUsers() throws Exception {

    final List<User> users = userService.findAll();

    final Map<String, Object> status = new HashMap<>();
    status.put("users", users);

    return new ResponseEntity<>(status, HttpStatus.OK);
  }


  @RequestMapping(value = "/{userId}", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> getUserById(@PathVariable final Integer userId)
      throws Exception {

    final User user = userService.findById(userId);

    final Map<String, Object> status = new HashMap<>();

    status.put("user", user);

    return new ResponseEntity<>(status, HttpStatus.OK);
  }


  @RequestMapping(value = "/update", method = RequestMethod.PUT,
      produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> updateUser(@RequestBody final User user)
      throws Exception {

    final Integer id = userService.updateUser(user);

    final Map<String, Object> status = new HashMap<>();
    status.put("status", String.format("User having id=%d, saved successfully", id));

    return new ResponseEntity<>(status, HttpStatus.OK);
  }


}
