package com.sapient.cucumber.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.sapient.reservation.page.FlightSearchPage;
import com.sapient.reservation.page.HomePage;
import com.sapient.reservation.page.RegisterUserPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FlightSearchStepDef extends BaseStepDef {

  private WebDriver driver = null;
  private HomePage homePage = null;

  @After
  public void cleanup(final Scenario scenario) {
    if (driver != null) {
      LOG.info("Closing WebDriver");
      // driver.quit();
      LOG.info("WebDriver closed successfully");
    }
  }

  @Given("^In a web browser user navigates to URL \"([^\"]*)\" and signs in$")
  public void navigateToUrl(final String urlKey) throws Throwable {

    driver = new FirefoxDriver();
    assertNotNull(driver);

    LOG.info("Navigate to URL={}", urlKey);

    driver.get(getPropValue(urlKey));
    LOG.info("Page Title: {}", driver.getTitle());

    assertEquals("Welcome: Mercury Tours", driver.getTitle());

    homePage = new HomePage(driver);

    assertEquals("Welcome: Mercury Tours",
        homePage.getPageTitleElement().getAttribute("innerText"));

    // Check todays date being displayed in home page
    final String today = DateTimeFormatter.ofPattern("MMM dd, yyyy").format(OffsetDateTime.now());
    assertEquals(today, homePage.getDateElement().getText());

    registerUser();
  }

  @Then("^user performs flight search$")
  public void performFlightSearch() {

    homePage.getLeftNav().showFlightSearchPage();

    final FlightSearchPage flightSearchPage = new FlightSearchPage(driver);

    flightSearchPage.getTripTypeRoundtrip().click();

    new Select(flightSearchPage.getPassengerCount()).selectByIndex(3);
    new Select(flightSearchPage.getFromPort()).selectByIndex(2);
    new Select(flightSearchPage.getFromMonth()).selectByIndex(2);
    new Select(flightSearchPage.getFromDay()).selectByIndex(2);
    new Select(flightSearchPage.getToPort()).selectByIndex(2);
    new Select(flightSearchPage.getToMonth()).selectByIndex(2);
    new Select(flightSearchPage.getToDay()).selectByIndex(2);

    flightSearchPage.getServiceClassFirst().click();
    new Select(flightSearchPage.getAirline()).selectByIndex(2);

    flightSearchPage.getFindFlightsButton().click();

  }

  private void registerUser() {
    // navigate to register user page
    homePage.getHeader().showRegisterUserPage();
    assertEquals("Register: Mercury Tours",
        homePage.getPageTitleElement().getAttribute("innerText"));


    final RegisterUserPage registerUserPage = new RegisterUserPage(driver);

    registerUserPage.getFirstNameElement().sendKeys(getPropValue("newtours.user.firstname"));
    registerUserPage.getLastNameElement().sendKeys(getPropValue("newtours.user.lastname"));
    registerUserPage.getEmailElement().sendKeys(getPropValue("newtours.user.username"));
    registerUserPage.getPasswordElement().sendKeys(getPropValue("newtours.user.password"));
    registerUserPage.getConfirmPasswordElement().sendKeys(getPropValue("newtours.user.password"));

    registerUserPage.getRegisterButtonElement().click();

  }
}
