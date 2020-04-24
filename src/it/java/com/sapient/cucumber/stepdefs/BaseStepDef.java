package com.sapient.cucumber.stepdefs;

import java.util.Properties;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseStepDef {

  @Autowired
  protected MockMvc mockMvc;

  @Autowired
  protected ObjectMapper mapper;

  @Value("classpath:data/test-data.properties")
  private Resource testDataResource;

  private final Properties props = new Properties();;

  protected Logger LOG = LoggerFactory.getLogger(getClass());

  protected String getPropValue(final String key) {
    return props.getProperty(key);
  }

  @PostConstruct
  private void readTestDataFile() throws Exception {
    props.load(testDataResource.getInputStream());
  }
}
