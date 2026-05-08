Feature:Directory Functionality
Scenario:Valid Emplyee Search
Given user is on Dashboard
When I enter Username in the Employee name suggestive dropdown
And I select Software Engineer from the Job Title dropdown
And I select New York from the Location dropdown
And I click on the Search button
Then I should see the employee Timothy Lewis Amiano in the search results