package com.sapient.cucumber.stepdefs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseStepDef {
  @Autowired
  protected MockMvc mockMvc;

  @Autowired
  protected ObjectMapper mapper;
}
