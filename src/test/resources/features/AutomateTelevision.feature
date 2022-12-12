
@test
Feature: Amazon automation

  Scenario: Amazon automation to find about section of second highest price television
    Given I navigate to Home page
    And I click on element Home.hamburger
    And I click on element Home.tv,appliances,electronics
    And I click on element Home.televisions
    Then I click on element Television.samsung
    And I click on element Television.sort_by
    And I click on element Television.high_to_low
    And I click on element Television.second_highest_price_item
    And I switch to child window 1
    Then I validate element ItemDetails.about_this_item
    And I log ItemDetails.about_item_contents list element text in console
