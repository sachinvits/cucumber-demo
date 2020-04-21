package com.sapient.cucumber.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchStepDef extends BaseStepDef {

  private WebDriver driver = null;
  private WebElement element = null;

  @After
  public void cleanup() {
    assertNotNull(driver);

    LOG.info("Closing WebDriver");
    driver.close();
    LOG.info("WebDriver closed successfully");
  }

  @Then("^Enter search keyword \"([^\"]*)\"$")
  public void enterSearchKeyword(final String keyword) throws Throwable {

    LOG.info("Search Keyword={}", keyword);

    assertNotNull(driver);
    assertNotNull(element);
    element.sendKeys(keyword);

    // TODO find element <ul class="erkvQe" >
    // assertEquals(keyword, element.getText());

  }

  @Then("^Find search textbox \"([^\"]*)\"$")
  public void findSearchTextBox(final String elementName) throws Throwable {

    LOG.info("Find search textbox={}", elementName);
    element = driver.findElement(By.name(elementName));

    assertNotNull(element);
    assertEquals("Search", element.getAttribute("title"));
    LOG.info("Element Title: {}", element.getAttribute("title"));
  }

  @Given("^Navigate to URL \"([^\"]*)\"$")
  public void navigateUrl(final String url) throws Throwable {

    LOG.info("Navigate to URL={}", url);

    driver = new FirefoxDriver();
    driver.get("http://www.google.com");
    LOG.info("Page Title: {}", driver.getTitle());

    assertNotNull(driver);
    assertEquals("Google", driver.getTitle());
  }

  @When("^Submit search$")
  public void submitSearch() throws Throwable {

    LOG.info("Submit Search");

    assertNotNull(driver);
    assertNotNull(element);
    element.submit();

    // assertEquals(keyword, element.getText());

  }

}
