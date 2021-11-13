package net.seamless.step_definitions;

import net.seamless.pages.HomePage;
import net.seamless.pages.LoginPage;
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

    @When("User enters username")
    public void user_enters_username() {
        loginPage.login(username,password);
    }

    @Then("User should login")
    public void user_should_login() {
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
        loginPage.login(username,password);
    }

    @Then("with {string} {string} the user should get {string}")
    public void with_the_user_should_get(String username, String password, String message) {

        if (username.isEmpty()) {
            element = loginPage.user;
        } else if (password.isEmpty()) {
            element = loginPage.password;
        }
        if (element != null) {
            Assert.assertEquals(message, loginPage.getErrorMessage(element));
            System.out.println(loginPage.getErrorMessage(element));
        } else {
            Assert.assertEquals(message, loginPage.noticeMessage.getText());
            System.out.println(loginPage.noticeMessage.getText());
        }
    }
    @When("the user enters password")
    public void the_user_enters_password() {
        loginPage.getPaswordDots(username,password);
    }

    @Then("the user should see he password in a form of dots by default")
    public void the_user_should_see_he_password_in_a_form_of_dots_by_default() {
       /*
        WebElement input = Driver.get().findElement(By.id(password));
        boolean isEncrypted = input.getAttribute("type").equals("password");
        System.out.println(isEncrypted);
        // Assert.assertTrue("True",isEncrypted);
        */
        System.out.println("wait");
    }
    @Then("User can see the password explicitly if needed")
    public void user_can_see_the_password_explicitly_if_needed() {

    }
}