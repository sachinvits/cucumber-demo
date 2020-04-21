package com.sapient.cucumber;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Cucumber Options
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/it/resources/features"},
    plugin = {"pretty", "html:target/cucumber"}, glue = {"com.sapient.cucumber.stepdefs"})
public class CucumberTestRunner {

  @BeforeClass
  public static void setup() {
    System.out.println("**** Setting up Cucumber Test ****");
  }

}
