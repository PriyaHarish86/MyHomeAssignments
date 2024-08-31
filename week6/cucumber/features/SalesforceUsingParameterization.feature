Feature: Verify Edit Account functionality of Salesforce Application

Scenario: Edit an account

Given Launch the browser and load the URL
When Enter Username as 'dilip@testleaf.com'
And Enter Password as 'testleaf@2024'
Then Click on Login button
When Click on toggle menu button from left corner
And  Click View All 
And Click Accounts from App Launcher
And Search for the account as 'Priya'
And Click the dropdown icon next to the account and select Edit
And Select Type as Technology Partner
And Select Industry as Healthcare
And Enter as Billing Address as '123, Main Street, NJ'
And Enter Shipping Address as '456, West Coast Road, CA'
And Select Customer Priority as Low
And Select SLA as Silver
And Select Active as No
And Enter unique number in Phone field '1234567890'
And Select Upsell Opportunity as No
And Click Save
Then Verify phone number
And Close the browser