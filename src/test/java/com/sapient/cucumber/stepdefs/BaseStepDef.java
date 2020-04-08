package com.sapient.cucumber.stepdefs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;

// @RunWith(SpringRunner.class)
// @ContextConfiguration
// @SpringBootTest(classes = CucumberApplication.class,
// webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


// @ContextConfiguration(classes = CucumberApplication.class,
// loader = SpringApplicationContextLoader.class)
// @WebAppConfiguration
// @IntegrationTest

public class BaseStepDef {

  @Autowired
  protected TestRestTemplate testRestTemplate;

  @LocalServerPort
  protected int port;

  protected String staticURL = "http://localhost:";

  protected HttpHeaders httpHeaders;

  // @Before
  // public void setUp() throws Exception {
  // httpHeaders = new HttpHeaders();
  // }
}
