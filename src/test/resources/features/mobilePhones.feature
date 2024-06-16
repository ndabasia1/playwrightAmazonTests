@mobilePhones
Feature: Tests related to the mobile phones section on Amazon

  Background: Navigate to the correct URL
    Given I have navigated to the correct URL
    
  @samsung
  Scenario: Test able to get all the Samsung phones with a certain set of specifications
    When I click All in the navigation bar
    And I click Electronics & Computers in the menu canvas
    And I click Phones & Accessories in the submenu canvas
    Then I will be taken to the correct search results screen
    When I click Mobile Phones & Smartphones within the banner
    Then I will be taken to the correct search results screen
		When I set Featured Brands to Samsung
		Then the filter will be checked
		When I set Camera Resolution to 20 MP & above
		Then the filter will be checked
		When I set Model Year to 2023
		Then the filter will be checked
#		When I slide the maximum price range to the far left
		Then I will get all the Samsung phones with the above set of specifications