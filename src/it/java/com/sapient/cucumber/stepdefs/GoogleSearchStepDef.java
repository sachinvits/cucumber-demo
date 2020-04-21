package com.sapient.cucumber.stepdefs;

import cucumber.api.java.en.Given;

public class GoogleSearchStepDef {

  // \"([^\"]*)\"

  @Given("^Navigate to URL \"([^\"]*)\"$")
  public void navigateUrl(final String url) throws Throwable {
    System.out.println("******************** URL=" + url);

  }
}
