Feature: Amazon Task


Scenario: Verify that the total amount of all items is correct with the shipping fees if exist
  Given I am on the amazon website and I open “All” menu from the left side
  And I click on “video games” then choose “all video games”
  And I add filter “free shipping” & add the filter of condition “new”
  And I sort by price: high to low 
  When I complete an order with all products that its cost below 15k EGP
  Then I see the total amount of all items is correct