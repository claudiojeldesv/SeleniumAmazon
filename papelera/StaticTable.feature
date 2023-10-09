
Feature: Test different actions on the List

#Importante Rule. Lo que hace es definir lo que se va a probar a modo general. Todos los escenarios deberan responder a esta reglac
Rule: The user can return values from the table and validate them.

@Test3
Scenario Outline: As a test Engineer, I want to validate that a text present inside the list.
    Given I navigate to the list page
    When I search <state> in the list2
    Then  I can find <city> in the list

    Examples: 
    |state      |city               |
    |Washington |Seattle, Washington2|
    |Chicago    |Chicago, Illinois  |