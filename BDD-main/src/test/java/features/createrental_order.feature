@createrental_order

Feature: Create Rental Order
  As an end user, I want to create an order on Kwikspace
  in order to get a quote.

  Background: Pre-Condition
    Given I Login to Kwikspace page

  Scenario: As a user I want to create a rental quote
    Given I have navigated to the dashboard
    When I click on Create a rental quote button
    Then Quote details should be displayed
    #Then I close the browser

    Scenario: Successfully create a quote for schools education in Johannesburg
      Given I have navigated to the dashboard
      When I click on Create a rental quote button
      Then Quote details should be displayed
      And I click on Search Customer button
      And I have entered "Velape Makwarimba" into the Search Textbox
      Then I select "Velape Makwarimba" from the customer dropdown list
      And I select "Schools & Classrooms" from the Building Type dropdown list
      And I select "Johannesburg" from the Select Location dropdown list
      And I select "Mining" from the Organizational Sector dropdown list
      Then I enter "Testing" in the notes textbox
      And I populate "221 Kings Crossing" in first address line field
      And I populate "219 Kerk Street" in second address line field
      And I populate "Midrand" in the suburb field
      Then I populate "1685" in the postal code field
      And I select "Gauteng" from the province dropdown list
      And I select "Johannesburg" from the district dropdown list
      And I select "Midrand" from the Area dropdown list

  Scenario: Successfully create Delivery and Collection Area for schools education in Johannesburg
    Given I have navigated to the dashboard
    When I click on Create a rental quote button
    Then Quote details should be displayed
    And I populate "221 Kings Crossing" in first address line field
    And I populate "219 Kerk Street" in second address line field
    And I populate "Midrand" in the suburb field
    Then I populate "1685" in the postal code field
    And I select "Gauteng" from the province dropdown list
    And I select "Johannesburg" from the district dropdown list
    And I select "Midrand" from the Area dropdown list
    Then I click enter button


  Scenario: Successfully create a Delivery and Collection Area for schools education in Johannesburg
    Given I have navigated to the dashboard
    When I click on Create a rental quote button
    Then Quote details should be displayed
    And I click on Search Customer button
    And I have entered "Velape Makwarimba" into the Search Textbox
    Then I select "Velape Makwarimba" from the customer dropdown list
    And I select "Clinics & Hospitals" from Building Type dropdown list
    And I select "Cape Town" from the Location dropdown list
    And I select "Construction" from Organizational Sector dropdown list
    Then I enter "Testing" in the notes textbox

