#Author: yuvaraj.email@your.domain.com
#Feature: TV Purchase
#Scenario: TV Purchase
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
@tv
Feature: TV Purchase

Background:
   Given User launch the app
    And User login by using credentials

  @MobTV
  Scenario: TV Purchase
  
   When user search the Tv 
    And user click on the Tv name
    Then user click on add tocart

@one
  Scenario: TV Purchase using one dim list
 
    When user search the TV in one dim list 
    |SONY BRAVIA 80 cm (32 inch) HD Ready LED Smart TV  (KDL-32W6103)|SAMSUNG 80 cm (32 inch) HD Ready LED Smart TV  (UA32T4340AKXXL / UA32T4340BKXXL)
    |Mi 5X 138.8 cm (55 inch) Ultra HD (4K) LED Smart Android TV with Dolby Atmos and Dolby Vision|
     And user click on the Tv name
    Then user click on add tocart
 
 