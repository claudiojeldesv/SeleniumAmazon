@Grid
Feature: Test different actions on a sandbox page

Background: Navigate to Table web app
    Given I navigate to the sandbox page

@Regression
Scenario: As a Test Engineer, I try out different actions on a sanbox page.
    And   select a value from the dropdown
    When  I search the list
    Then  I can return the value I wanted

@Smoke @Regression
Scenario: As a Test Engineer, I want to validate the static table is displayed.
    Then  I can validate the table displayed


# gradle test -D cucumber.options="--tags @Smoke" para ejecutar lo que tenga tag @Smoke en la linea de comandos
