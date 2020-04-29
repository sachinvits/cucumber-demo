package com.sapient.reservation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sapient.reservation.pom.BasePage;

public class RegisterUserPage extends BasePage {

  @FindBy(name = "firstName")
  private WebElement firstNameElement;

  @FindBy(name = "lastName")
  private WebElement lastNameElement;

  @FindBy(id = "email")
  private WebElement emailElement;

  @FindBy(name = "password")
  private WebElement passwordElement;

  @FindBy(name = "confirmPassword")
  private WebElement confirmPasswordElement;

  @FindBy(name = "register")
  private WebElement registerButtonElement;

  public RegisterUserPage(final WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public WebElement getConfirmPasswordElement() {
    return confirmPasswordElement;
  }

  public WebElement getEmailElement() {
    return emailElement;
  }

  public WebElement getFirstNameElement() {
    return firstNameElement;
  }

  public WebElement getLastNameElement() {
    return lastNameElement;
  }

  public WebElement getPasswordElement() {
    return passwordElement;
  }

  public WebElement getRegisterButtonElement() {
    return registerButtonElement;
  }


}
