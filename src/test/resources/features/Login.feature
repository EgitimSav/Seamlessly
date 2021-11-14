Feature: Login
  As a user, I should be able to login.

  @valid
  Scenario: User can login with valid credentials
    Given the user is on the login page
    When User enters username and password
    Then User should login
    And  User should see the username after clicking on the profile icon at the top right

  @invalid
  Scenario Outline:User can not login with any "<invalid credentials>"

    Given  the user is on the login page
    When the user navigates to "<username>" "<password>"
    Then with "<username>" "<password>" the user should get "<message>"
    Examples:
      | username   | password    | message                     |
      | Employee61 | 11111       | Wrong username or password. |
      | 111        | Employee123 | Wrong username or password. |
      |            |             | Please fill out this field. |
      |            | Employee123 | Please fill out this field. |
      | Employee61 |             | Please fill out this field. |

  @wip @dot_form
  Scenario: User can see the password in a form of dots by default or explicitly if needed
    Given the user is on the login page
    When User enters username and password
    Then the user should see the password in a form of dots by default
    When The user click on the eye icon at the right side of password icon
    Then User can see the password explicitly
    And User can see the Forgot password? link on the login page
    When the user click on  Forgot password?
    And User can see the Reset Password button on the next page