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
    public WebElement password;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginButton;

    @FindBy(css = ".warning.wrongPasswordMsg")
    public WebElement noticeMessage;

    @FindBy(css = "#password")
    public WebElement passWordDots;

    public void login (String userName, String passWord){
        user.sendKeys(userName);
        password.sendKeys(passWord);
        loginButton.click();
    }
    public String getErrorMessage(WebElement element){
        return element.getAttribute("validationMessage");
    }
    public void getPaswordDots(String userName, String passWord){
        user.sendKeys(userName);
        password.sendKeys(passWord);

    }
}
