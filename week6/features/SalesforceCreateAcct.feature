Feature: Create New Account functionality of Salesforce Application

Scenario Outline: Creating a new account

Given Launch the browser and load the URL
When Enter Username as <userName>
And Enter Password as <pwd>
Then Click on Login button
When Click on toggle menu button from left corner
And  Click view All 
And Click Legal Entities from App Launcher
And Click on Accounts dropdown
And Click on New Account button
And Enter account name as <name>
And Select ownership as Public
And Click on Save button
Then Verify Account name is created
And Close the browser


Examples:
|userName|pwd|name|
|'dilip@testleaf.com'|'testleaf@2024'|'Priya Harish'|