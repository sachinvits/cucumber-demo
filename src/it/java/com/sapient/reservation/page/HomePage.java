package com.sapient.reservation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sapient.reservation.pom.BasePage;

public class HomePage extends BasePage {

  @FindBy(
      xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[1]/td/font/b")
  private WebElement dateElement;

  public HomePage(final WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public WebElement getDateElement() {
    return dateElement;
  }

}
