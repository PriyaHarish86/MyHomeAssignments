Feature: Accounts module functionality of LeafTaps Application

#Background: 
#Given Launch the browser and load the URL, login with valid credentials and click on Accounts  

@CreateAccount
Scenario Outline: Create an Account

When Click Create Account from left pane
And Enter account name as <name>
And Select ownership as Corporation
And Enter description
And Enter site name
And Enter Number of Employees
Then Click on Create Account button
And Verify account creation is successful

Examples:
|name|
|'Priya Harish'|

@EditAccount
Scenario Outline: Verify Edit Account
When Click on Find Accounts from left pane
And Enter AccountName as <name>
And Click on Find Accounts button
And Click on first item in Account list
And Click on Edit button
And Update description
And Update Number of Employees
Then Click on Save
And Verify edit account is successful

Examples:
|name|
|'Priya'|

@DeleteAccount
Scenario Outline: Verify Delete Account
When Click on Find Accounts from left pane
And Enter AccountName as <name>
And Click on Find Accounts button
And Click on first item in Account list
Then Click on Deactivate Account button
And Verify Delete Account is successful

Examples:
|name|
|'Priya'|
