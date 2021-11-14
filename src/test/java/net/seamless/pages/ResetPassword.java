package net.seamless.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPassword extends BasePage{
    @FindBy(id = "reset-password-submit")
    public WebElement reset;
}
