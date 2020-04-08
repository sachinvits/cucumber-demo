package com.sapient.cucumber;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
// @ContextConfiguration(classes = CucumberApplication.class, loader =
// SpringBootContextLoader.class)
public class CucumberApplicationTests {

  private static final Logger LOG = LoggerFactory.getLogger(CucumberApplicationTests.class);

  // @Test
  // void contextLoads() {}

  /**
   * Need this method so the cucumber will recognize this class as glue and load spring context
   * configuration
   */
  @Before
  public void setUp() {
    LOG.info("*****************Spring Context Initilized*********************");
  }
}
