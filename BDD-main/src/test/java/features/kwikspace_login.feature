@kwikspace_login

Feature: Kwikspace login

  Scenario: As a user i want to be able to log into Kwikspace application
    Given i have launched the browser
    When i capture username and the password
    And i click on login button
    Then i validate if the user able to login
    Then I close the browser

  Scenario: As a user i want to unsuccessfully log into Kwikspace application
    Given i have launched the browser
    When i capture wrong username and the correct password
    And an error message should be displayed
    And i click on login button
    Then i validate if the user able to login
    Then I close the browser

  Scenario: As a user i want to unsuccessfully log into Kwikspace application
    Given i have launched the browser
    When i capture wrong username and the wrong password
    And an error message should be displayed
    And i click on login button
    Then i validate if the user able to login
    Then I close the browser

  Scenario: As a user i want to unsuccessfully log into Kwikspace application
    Given i have launched the browser
    When i capture correct username and the wrong password
    And an error message should be displayed
    And i click on login button
    Then i validate if the user able to login
    Then I close the browser