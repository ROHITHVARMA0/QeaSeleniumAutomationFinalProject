Feature: JustDial Core Functionality Automation

  Background: Common Navigation and Setup
    # Runs ONCE at the start of the whole test run (handled by @BeforeAll navigating)
    Given I navigate to the JustDial homepage
    # Handles initial login/notification pop-ups only if present
    And I handle the login prompt and notification pop-ups

  Scenario: Search and Filter for 5 Highest Rated Car Washing Services
    When I search for "Car Washing Services Near me"
    And I apply the filter for "Rating" greater than "4.0+"
    And I scroll the page to load more results
    Then I should extract and display the top 5 car washing service names and phone numbers
    # Resets the browser state for the next scenario
    And I should navigate back to the homepage 

  Scenario: Capture Error Message on Invalid Phone Number Input
    # Navigates back to the clean homepage state (handled by a Given step in hooks)
    Given I navigate back to the JustDial homepage 
    And I click on the "Free Listing" link
    When I enter an invalid phone number "1234567890" and click Start Now
    Then I should capture and print the validation error message
    And I take a screenshot of the error message
    # Resets the browser state for the next scenario
    And I should navigate back to the homepage 

  Scenario: Retrieve and Display all Gym Listings
    # Navigates back to the clean homepage state (handled by a Given step in hooks)
    Given I navigate back to the JustDial homepage 
    When I click on the "Gym" icon
    And I scroll the page to load all gym listings
    Then I should extract and display all visible gym names and phone numbers
    # Final step, @AfterAll will quit the driver after this scenario completes.
    And I should navigate back to the homepage