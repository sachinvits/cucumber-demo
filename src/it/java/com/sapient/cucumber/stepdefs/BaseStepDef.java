package com.sapient.cucumber.stepdefs;

import java.time.Duration;
import java.util.Properties;
import javax.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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

  public Wait<WebDriver> getFluentWait(final WebDriver driver) {
    final Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)//
        .withTimeout(Duration.ofSeconds(10))//
        .pollingEvery(Duration.ofSeconds(1));//
    return wait;
  }

  protected String getPropValue(final String key) {
    return props.getProperty(key);
  }

  @PostConstruct
  private void readTestDataFile() throws Exception {
    props.load(testDataResource.getInputStream());
  }
}
