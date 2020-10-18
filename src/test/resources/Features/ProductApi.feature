Feature: Validate Product API

  Scenario: Validate product api with valid data
    Given I hava a valid endpoint for productapi
    When I navitage to productapi endpoint
    Then I get 200 as response code
    And I get limit as 10 in response
    And I get total as 51958 in response
    And I get skip as 0 in response
