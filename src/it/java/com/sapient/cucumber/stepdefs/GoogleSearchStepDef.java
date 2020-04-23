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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

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

  @And("^user enters search keyword \"([^\"]*)\"$")
  public void enterSearchKeyword(final String searchKeyword) throws Throwable {

    LOG.info("Search Keyword={}", searchKeyword);

    assertNotNull(driver);
    assertNotNull(element);
    element.sendKeys(searchKeyword);

    final WebElement suggestions =
        getFluentWait().until((driver) -> driver.findElement(By.className("erkvQe")));

    assertNotNull(suggestions);
    assertEquals("ul", suggestions.getTagName());

  }

  @Then("^on web page find search box$")
  public void findSearchTextBox() throws Throwable {
    final String elementName = "q";

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

  @Given("^A web browser$")
  public void initWebBrowser() {
    LOG.info("Given A web browser");

    driver = new FirefoxDriver();
    assertNotNull(driver);
  }

  @Given("^User navigates to URL \"([^\"]*)\"$")
  public void navigateToUrl(final String url) throws Throwable {

    LOG.info("Navigate to URL={}", url);
    assertNotNull(driver);
    driver.get("http://www.google.com");
    LOG.info("Page Title: {}", driver.getTitle());

    assertNotNull(driver);
    assertEquals("Google", driver.getTitle());
  }

  @And("^user submits the page to perform search$")
  public void submitSearch() throws Throwable {

    LOG.info("Submit Search");

    final WebElement searchBtn = driver.findElement(By.name("btnK"));

    assertNotNull(searchBtn);
    assertEquals("Google Search", searchBtn.getAttribute("aria-label"));

    searchBtn.submit();

  }

  @Then("^verify that page displays search results for \"([^\"]*)\"$")
  public void verifySearchResults(final String searchKeyword) throws Throwable {

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
