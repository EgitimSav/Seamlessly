package net.seamless.pages;

import net.seamless.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//input[@id='user']")
    public WebElement user;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement pass;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginButton;

    @FindBy(css = ".warning.wrongPasswordMsg")
    public WebElement noticeMessage;

    @FindBy(css = "#password")
    public WebElement passWordDots;

    @FindBy(css = "a[class='toggle-password']")
    public WebElement eyeIcon;

    @FindBy(id = "lost-password")
    public WebElement forgotPassword;

    public void enterUsername (String username){
        user.sendKeys(username);
    }
    public void enterPassword (String password){
        pass.sendKeys(password);
    }
    public String getErrorMessage(WebElement element){
        return element.getAttribute("validationMessage");
    }

    public String getPlaceholder(String webelement){
        WebElement element;
      switch (webelement){
            case "username":
                element = user;
                break;
            case "password":
                element = pass;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + webelement);
        }
        return element.getAttribute("placeholder");
    }
}
