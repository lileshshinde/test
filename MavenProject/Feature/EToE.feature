Feature: End To End 
 
    
Scenario: User Login into flipkart adding product and Logout
    Given User is on Login Page
    When User enters UserName and Password
    Then User is on Flipkart Homepage
    And Massage displayed Login Successfully
    Then User searching for the product
    And User adding the product into cart
    Then User logout form application
    And Logout massage displayed successfully