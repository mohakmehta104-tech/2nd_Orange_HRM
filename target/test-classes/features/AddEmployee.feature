Feature: Add Employee in OrangeHRM
Scenario: Add a new employee and verify details
Given I am logged into OrangeHRM
When I click on the PIM menu
And I click on the Add button
And I enter employee details First Name "Anuj", Middle Name "S", Last Name "Mehta"
Then Print a message that user created successfully