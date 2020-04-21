package com.sapient.cucumber.config;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.sapient.cucumber.CucumberApplication;
import cucumber.api.java.Before;


@ContextConfiguration
@AutoConfigureMockMvc
@SpringBootTest(classes = CucumberApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberTestContextConfig {


  /**
   * <code>@cucumber.api.java.Before</code> is required. This annotation will make this class as a
   * Step Definition and while instantiating it will automatically initialize Spring Context.
   * 
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    System.out.println("**** Setting up Cucumber Test Spring Context ****");
    System.setProperty("webdriver.gecko.driver", "C:\\dev\\softwares\\selenium\\geckodriver.exe");
  }

}
