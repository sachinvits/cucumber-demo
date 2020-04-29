package com.sapient.cucumber.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GoogleSearchStepDef extends BaseStepDef {

  private WebDriver driver = null;
  private WebElement element = null;

  @After
  public void cleanup(final Scenario scenario) {
    if (driver != null) {
      LOG.info("Closing WebDriver");
      driver.quit();
      LOG.info("WebDriver closed successfully");
    }
  }

  @Then("^user enters keyword \"([^\"]*)\" in search box$")
  public void enterSearchKeyword(final String searchKeyword) throws Throwable {

    findSearchTextBox();

    final String keyword = getPropValue(searchKeyword);
    LOG.info("Search Keyword={}", keyword);

    assertNotNull(driver);
    assertNotNull(element);
    element.sendKeys(keyword);

    final WebElement suggestions =
        getFluentWait(driver).until((driver) -> driver.findElement(By.className("erkvQe")));

    assertNotNull(suggestions);
    assertEquals("ul", suggestions.getTagName());

  }

  private void findSearchTextBox() throws Throwable {
    final String elementName = getPropValue("google.search.textbox.name");

    element = driver.findElement(By.name(elementName));

    assertNotNull(element);
    assertEquals("Search", element.getAttribute("title"));
    LOG.info("Element Title: {}", element.getAttribute("title"));
  }

  @Given("^In a web browser user navigates to URL \"([^\"]*)\"$")
  public void navigateToUrl(final String url) throws Throwable {

    driver = new FirefoxDriver();
    assertNotNull(driver);

    LOG.info("Navigate to URL={}", url);

    driver.get(getPropValue(url));
    LOG.info("Page Title: {}", driver.getTitle());

    assertEquals("Google", driver.getTitle());
  }

  @Then("^user submits the page to perform search$")
  public void submitSearch() throws Throwable {

    LOG.info("Submit Search");

    final WebElement searchBtn = driver.findElement(By.name("btnK"));

    assertNotNull(searchBtn);
    assertEquals("Google Search", searchBtn.getAttribute("aria-label"));

    searchBtn.submit();

  }

  @Then("^verify that page displays search results for keyword \"([^\"]*)\" with message:$")
  public void verifySearchResults(final String searchKeyword, final String expectedResult)
      throws Throwable {

    LOG.info("Verifying search results");

    getFluentWait(driver).until((driver) -> driver.getTitle()
        .equals(String.format("%s - Google Search", getPropValue(searchKeyword))));

    getFluentWait(driver).until((driver) -> driver.findElement(By.id("ucs")));

    final WebElement resultStats =
        getFluentWait(driver).until((driver) -> driver.findElement(By.id("result-stats")));

    assertNotNull(resultStats);
    // assertTrue(resultStats.getText().contains("About"));

    assertTrue(resultStats.getText().startsWith(getPropValue(expectedResult)));

  }

}
