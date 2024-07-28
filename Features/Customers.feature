
#Background Keyword -> for common/ repeating steps in Scenarios.

Feature: Customer
Background: Steps Common for all scenarios
		Given User Launch Chrome Browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
     
@regression
Scenario Outline: Add New Customer
    When User click on customers Menu
		And click on Customers Menu Item
		And click on Add new button
		Then User can view Add new customer page
		When User enter customer info
		And click on Save button
		Then User can view confirmation message "The new customer has been added successfully."
		And Close the Browser
		

# this scenario will be executed for both the below tags:		
#@Sanity @regression
#Scenario: Search Customer by Email
		#When User click on customers Menu
		#And click on customers Menu Item
		#And Enter customer Email
		#When Click on Search button
		#Then User should found Email in the Search table
		#And Close the Browser.
		
		
# this scenario will be executed for regression tag:
@regression		
Scenario: Search Customer by Name
		When User click on customers Menu
		And click on customers Menu Item
		And Enter customer FirstName
		And Enter customer LastName
		When Click on Search button
		Then User should found Name in the Search table
		And Close the Browser.
		
		
		
		
		
		
		
	