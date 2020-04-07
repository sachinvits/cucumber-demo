package com.sapient.cucumber;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CucumberApplication.class, loader = SpringBootContextLoader.class)
class CucumberApplicationTests {

  private static final Logger LOG = LoggerFactory.getLogger(CucumberApplicationTests.class);

  @Test
  void contextLoads() {}

  /**
   * Need this method so the cucumber will recognize this class as glue and load spring context
   * configuration
   */
  @Before
  public void setUp() {
    LOG.info("Spring Context Initilized");
  }
}
