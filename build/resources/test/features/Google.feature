#1. Escribir el Feature File con lo solicitado

@Amazon
Feature: Test amazon search functionality

    @Cart
    Scenario Outline: As customer then I search for Alexa. I want to see if the third option on the second page is available for purchase and can be added to the cart.
        Given the user navigates to www.amazon.com
        And  searches for <Product>
        #And  navigates to the second page
        And  selects the third item
        Then  the user is able to add it to the Cart

        Examples:
                |Product        |
                |Alexa 3        |
                |PlayStation 4  |


    