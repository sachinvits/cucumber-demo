package com.sapient.reservation.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
  private final WebDriver driver;

  @FindBy(linkText = "SIGN-ON")
  private WebElement signOnLink;

  @FindBy(linkText = "REGISTER")
  private WebElement registerLink;

  @FindBy(linkText = "SIGN-OFF")
  private WebElement signOffLink;

  public Header(final WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void showRegisterUserPage() {
    registerLink.click();
  }

  public void showSignInPage() {
    signOnLink.click();
  }

  public void signOff() {
    signOffLink.click();
  }

}
