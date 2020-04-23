package com.sapient.cucumber.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.time.Duration;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchStepDef extends BaseStepDef {

  private WebDriver driver = null;
  private WebElement element = null;
  private String searchKeyword = null;

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
    searchKeyword = keyword;

    assertNotNull(driver);
    assertNotNull(element);
    element.sendKeys(searchKeyword);

    // final WebElement suggestions = wait.until(new Function<WebDriver, WebElement>() {
    //
    // @Override
    // public WebElement apply(final WebDriver driver) {
    // return driver.findElement(By.className("erkvQe"));
    // }
    //
    // });

    final WebElement suggestions =
        getFluentWait().until((driver) -> driver.findElement(By.className("erkvQe")));

    assertNotNull(suggestions);
    assertEquals("ul", suggestions.getTagName());

  }

  @Then("^Find search textbox \"([^\"]*)\"$")
  public void findSearchTextBox(final String elementName) throws Throwable {

    LOG.info("Find search textbox={}", elementName);
    element = driver.findElement(By.name(elementName));

    assertNotNull(element);
    assertEquals("Search", element.getAttribute("title"));
    LOG.info("Element Title: {}", element.getAttribute("title"));
  }

  private Wait<WebDriver> getFluentWait() {
    final Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)//
        .withTimeout(Duration.ofSeconds(10))//
        .pollingEvery(Duration.ofSeconds(1));//
    return wait;
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

    final WebElement searchBtn = driver.findElement(By.name("btnK"));

    assertNotNull(searchBtn);
    assertEquals("Google Search", searchBtn.getAttribute("aria-label"));

    searchBtn.submit();

  }

  @When("^Verify search results$")
  public void verifySearchResults() throws Throwable {

    LOG.info("Verifying search results");

    getFluentWait().until(
        (driver) -> driver.getTitle().equals(String.format("%s - Google Search", searchKeyword)));

    getFluentWait().until((driver) -> driver.findElement(By.id("ucs")));

    final WebElement resultStats =
        getFluentWait().until((driver) -> driver.findElement(By.id("result-stats")));

    assertNotNull(resultStats);
    assertTrue(resultStats.getText().contains("About"));

  }

}
