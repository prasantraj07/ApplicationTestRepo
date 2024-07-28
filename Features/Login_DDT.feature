
# Data Driven Testing:
#Below scenario will run for 2 data sets: 

Feature: Login

@regression
Scenario Outline: Successfull Login with Valid Credentials DDT
    Given User Launch Chrome Browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
		And Close the Browser
		
Examples:
|email|password|
|admin@yourstore.com|admin|
|test@yourstore.com|admin|