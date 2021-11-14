package net.seamless.step_definitions;

import net.seamless.pages.HomePage;
import net.seamless.pages.LoginPage;
import net.seamless.pages.ResetPassword;
import net.seamless.utilities.BrowserUtils;
import net.seamless.utilities.ConfigurationReader;
import net.seamless.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




public class LoginStepDefinitions {
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
    WebElement element = null;
    String username=ConfigurationReader.get("username");
    String password=ConfigurationReader.get("password");

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("User should login")
    public void user_should_login() {
        loginPage.loginButton.click();
        BrowserUtils.waitFor(5);
        String actualTitle=Driver.get().getTitle();

        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals("Files - Seamlessly -QA", actualTitle);

    }
    @Then("User should see the username after clicking on the profile icon at the top right")
    public void user_should_see_the_username_after_clicking_on_the_profile_icon_at_the_top_right() {
        BrowserUtils.waitFor(5);
        homePage.profileIcon.click();
        String actualProfileName=homePage.profileName.getText();

        Assert.assertEquals("Barış",actualProfileName);
    }
    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.loginButton.click();
    }

    @Then("with {string} {string} the user should get {string}")
    public void with_the_user_should_get(String username, String password, String message) {

        if (username.isEmpty()) {
            element = loginPage.user;
        } else if (password.isEmpty()) {
            element = loginPage.pass;
        }
        if (element != null) {
            Assert.assertEquals(message, loginPage.getErrorMessage(element));
            System.out.println(loginPage.getErrorMessage(element));
        } else {
            Assert.assertEquals(message, loginPage.noticeMessage.getText());
            System.out.println(loginPage.noticeMessage.getText());
        }
    }


    @Then("the user should see the password in a form of dots by default")
    public void the_user_should_see_the_password_in_a_form_of_dots_by_default() {
        Assert.assertEquals("password",loginPage.pass.getAttribute("type"));
    }

    @When("The user click on the eye icon at the right side of password icon")
    public void the_user_click_on_the_eye_icon_at_the_right_side_of_password_icon() {
        loginPage.eyeIcon.click();
    }

    @Then("User can see the password explicitly")
    public void user_can_see_the_password_explicitly() {
        Assert.assertEquals("text",loginPage.pass.getAttribute("type"));
    }
    @Then("User can see the Forgot password? link on the login page")
    public void user_can_see_the_Forgot_password_link_on_the_login_page() {
      Assert.assertTrue(loginPage.forgotPassword.isDisplayed());
    }

    @When("the user click on  Forgot password?")
    public void the_user_click_on_Forgot_password() {
        loginPage.forgotPassword.click();
    }

    @When("User can see the Reset Password button on the next page")
    public void user_can_see_the_Reset_Password_button_on_the_next_page() {
        ResetPassword resetPassword=new ResetPassword();
        BrowserUtils.waitFor(5);
        Assert.assertTrue(resetPassword.reset.isDisplayed());
    }


}