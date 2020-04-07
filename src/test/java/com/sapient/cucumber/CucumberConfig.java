package com.sapient.cucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Cucumber Options
 */
@RunWith(Cucumber.class)
@CucumberOptions(//
    features = "src/test/resources/features", //
    plugin = {"pretty", "html:target/cucumber"}, //
    glue = {"com.sapient.cucumber.stepdefs"}//
) //
public class CucumberConfig {

}
