package com.sapient.reservation.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav {
  private final WebDriver driver;

  @FindBy(linkText = "Flights")
  private WebElement flightsSearchLink;

  public LeftNav(final WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void showFlightSearchPage() {
    flightsSearchLink.click();
  }
}
