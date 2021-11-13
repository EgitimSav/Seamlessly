package net.seamless.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = ".avatardiv.avatardiv-shown")
    public WebElement profileIcon;

    @FindBy(css = "span[class='user-status-menu-item__header']")
    public WebElement profileName;
}
