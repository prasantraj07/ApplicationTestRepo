
Feature: Login

@Sanity
Scenario: Successfull Login with Valid Credentials
    Given User Launch Chrome Browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
		And Close the Browser
		

 
