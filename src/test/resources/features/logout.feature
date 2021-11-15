Feature: LogOut
  As a user, I should be able to log out.

  @logout
  Scenario: User can log out and ends up in login page
    Given User should login successfully
    When the use should click on profile icon at the top right
    Then The user should see a drop down menu and click on log out option
    Then The user should log out and login page opens