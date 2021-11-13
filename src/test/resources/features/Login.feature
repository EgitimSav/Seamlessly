Feature: Login
  As a user, I should be able to login.

  @valid
  Scenario: User can login with valid credentials
    Given the user is on the login page
    When User enters username
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
  |            | Employee123 | Please fill out this field. |
  | Employee61 |             | Please fill out this field. |

  @wip @dot_form
  Scenario: User can see the password in a form of dots by default
    Given the user is on the login page
    When the user enters password
    Then the user should see he password in a form of dots by default
    And User can see the password explicitly if needed