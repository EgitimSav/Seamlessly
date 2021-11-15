package net.seamless.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(css = ".avatardiv.avatardiv-shown")
    public WebElement profileIcon;

    @FindBy(css = "span[class='user-status-menu-item__header']")
    public WebElement profileName;

    @FindBy(xpath = "//div//div//nav//li[@data-id]")
    public List<WebElement> setStatus;

    @FindBy(xpath = "//a[contains(.,'Log out')]")
    public WebElement logOut;
}
