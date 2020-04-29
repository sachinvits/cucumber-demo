package com.sapient.reservation.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
  protected WebDriver driver;

  protected LeftNav leftNav;

  protected Header header;

  @FindBy(how = How.TAG_NAME, tagName = "title")
  private WebElement pageTitleElement;

  public BasePage(final WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);

    leftNav = new LeftNav(driver);
    header = new Header(driver);
  }

  public Header getHeader() {
    return header;
  }

  public LeftNav getLeftNav() {
    return leftNav;
  }

  public WebElement getPageTitleElement() {
    return pageTitleElement;
  }

}
