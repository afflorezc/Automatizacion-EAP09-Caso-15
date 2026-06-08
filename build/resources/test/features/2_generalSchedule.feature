Feature: as a provider I want to configure my general schedule so I can offer availability slots to customers

  @requiresLoginProvider
  Scenario: provider saves default general schedule
    Given that I am on the schedule page
    When I save the general schedule
    Then I can see a message indicating that the schedule was successfully saved