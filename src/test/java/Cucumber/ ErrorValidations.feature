Feature: Error Validations

  Background:
    Given I landed on Login Page

  @ErrorValidations
  Scenario Outline: Login with incorrect credentials
    When Enter with  <name> and <password>
    Then the user should see the error message "Incorrect email or password"

    Examples:
      | name              | password   |  |  |
      | anshika@gmail.com | Iamking@00 |  |  |