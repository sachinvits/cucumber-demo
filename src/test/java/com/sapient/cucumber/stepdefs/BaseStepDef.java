package com.sapient.cucumber.stepdefs;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import com.sapient.cucumber.CucumberApplication;

@ContextConfiguration
@SpringBootTest(classes = CucumberApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseStepDef {

  @Autowired
  public TestRestTemplate testRestTemplate;

  @LocalServerPort
  public int port;

  public String staticURL = "http://localhost:";

  public HttpHeaders httpHeaders;

  @Before
  public void setUp() throws Exception {
    httpHeaders = new HttpHeaders();
  }
}
