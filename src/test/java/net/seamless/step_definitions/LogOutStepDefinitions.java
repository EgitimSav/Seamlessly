package net.seamless.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamless.pages.HomePage;
import net.seamless.pages.LoginPage;
import net.seamless.utilities.BrowserUtils;
import net.seamless.utilities.ConfigurationReader;
import net.seamless.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.util.List;

public class LogOutStepDefinitions {
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();

    @Given("User should login successfully")
    public void user_should_login_successfully() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        String username= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
       loginPage.enterUsername(username);
       loginPage.enterPassword(password);
       loginPage.loginButton.click();
    }

    @When("the use should click on profile icon at the top right")
    public void the_use_should_click_on_profile_icon_at_the_top_right() {
        homePage.waitUntilLoaderScreenDisappear();
        homePage.profileIcon.click();
    }

    @Then("The user should see a drop down menu options and click on log out option")
    public void the_user_should_see_a_drop_down_menu_options_and_click_on_log_out_option(List<String> menuOptions) {
        List<String>actualOptions=BrowserUtils.getElementsText(homePage.setStatus);
        Assert.assertEquals(actualOptions,menuOptions);
        homePage.logOut.click();
    }

    @Then("The user should log out and login page opens")
    public void the_user_should_log_out_and_login_page_opens() {
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals("Seamlessly -QA",actualTitle);
    }
    @When("the user click on step back button")
    public void the_user_click_on_step_back_button() {
        Driver.get().navigate().back();
        Driver.get().navigate().forward();
    }

    @Then("User can not go to home page again")
    public void user_can_not_go_to_home_page_again() {

        Assert.assertEquals("Seamlessly -QA",Driver.get().getTitle());
    }
}



