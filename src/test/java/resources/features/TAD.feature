Feature: Add a new attribute

  Background: The administrator is on opencart.com and logged in with his credentials

  Scenario: Adding a new attribute
    Given the administrator is on Attribute section
    When click on Add New button
    And input valid value in Attribute Name field
    And Select value from Attribute Group dropdown
    And input valid value in Sort Order field
    When click [Save] Button
    Then check for the success message
    And inspect the Attribute List for the newly added value