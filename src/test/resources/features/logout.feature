@logout
Feature: LogOut
  As a user, I should be able to log out.

  @wip
  Scenario: User can log out and ends up in login page
    Given User should login successfully
    When the use should click on profile icon at the top right
    Then The user should see a drop down menu options and click on log out option
      | Settings |
      | Help     |
      | Log out  |

    Then The user should log out and login page opens

    @stepback @wip
  Scenario: User can not go to home page again by clicking step back button after successfully logged out.
    Given the user is on the login page
    When the user click on step back button
    Then User can not go to home page again