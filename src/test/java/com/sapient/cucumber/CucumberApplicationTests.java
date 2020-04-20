package com.sapient.cucumber;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = CucumberApplication.class, loader = SpringBootContextLoader.class)
public class CucumberApplicationTests {

  private static final Logger LOG = LoggerFactory.getLogger(CucumberApplicationTests.class);

  @Test
  public void contextLoads() {


  }

  /**
   * Need this method so the cucumber will recognize this class as glue and load spring context
   * configuration
   */
  @Before
  public void setUp() {
    LOG.info("*****************Spring Context Initilized*********************");
  }
}
