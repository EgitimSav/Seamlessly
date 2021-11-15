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
      homePage.profileIcon.click();
    }

    @Then("The user should see a drop down menu and click on log out option")
    public void the_user_should_see_a_drop_down_menu_and_click_on_log_out_option() {

    }

    @Then("The user should log out and login page opens")
    public void the_user_should_log_out_and_login_page_opens() {
        System.out.println("wait");
    }

}



