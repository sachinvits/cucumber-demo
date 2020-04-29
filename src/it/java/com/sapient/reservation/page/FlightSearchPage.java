package com.sapient.reservation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sapient.reservation.pom.BasePage;

public class FlightSearchPage extends BasePage {

  @FindBy(xpath = "//input[@name='tripType' and @value='oneway']")
  private WebElement tripTypeOneWay;

  @FindBy(xpath = "//input[@name='tripType' and @value='roundtrip']")
  private WebElement tripTypeRoundtrip;

  @FindBy(name = "passCount")
  private WebElement passengerCount;

  @FindBy(name = "fromPort")
  private WebElement fromPort;

  @FindBy(name = "fromMonth")
  private WebElement fromMonth;

  @FindBy(name = "fromDay")
  private WebElement fromDay;

  @FindBy(name = "toPort")
  private WebElement toPort;

  @FindBy(name = "toMonth")
  private WebElement toMonth;

  @FindBy(name = "toDay")
  private WebElement toDay;

  @FindBy(xpath = "//input[@name='servClass' and @value='Coach']")
  private WebElement serviceClassEconomy;

  @FindBy(xpath = "//input[@name='servClass' and @value='Business']")
  private WebElement serviceClassBiz;

  @FindBy(xpath = "//input[@name='servClass' and @value='First']")
  private WebElement serviceClassFirst;

  @FindBy(name = "airline")
  private WebElement airline;

  @FindBy(name = "findFlights")
  private WebElement findFlightsButton;

  public FlightSearchPage(final WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public WebElement getAirline() {
    return airline;
  }

  public WebElement getFindFlightsButton() {
    return findFlightsButton;
  }

  public WebElement getFromDay() {
    return fromDay;
  }

  public WebElement getFromMonth() {
    return fromMonth;
  }

  public WebElement getFromPort() {
    return fromPort;
  }

  public WebElement getPassengerCount() {
    return passengerCount;
  }

  public WebElement getServiceClassBiz() {
    return serviceClassBiz;
  }

  public WebElement getServiceClassEconomy() {
    return serviceClassEconomy;
  }

  public WebElement getServiceClassFirst() {
    return serviceClassFirst;
  }

  public WebElement getToDay() {
    return toDay;
  }

  public WebElement getToMonth() {
    return toMonth;
  }

  public WebElement getToPort() {
    return toPort;
  }

  public WebElement getTripTypeOneWay() {
    return tripTypeOneWay;
  }

  public WebElement getTripTypeRoundtrip() {
    return tripTypeRoundtrip;
  }

}
