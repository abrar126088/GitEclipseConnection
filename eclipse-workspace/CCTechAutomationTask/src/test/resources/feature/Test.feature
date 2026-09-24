Feature: DemoQA Practice Form - Submission Scenarios

  # Positive Scenarios
  Scenario: Submit with all valid details
    Given user is on the practice form page
    When user fills all valid details
    And submits the form
    Then success modal should appear

  Scenario: Submit with only mandatory fields
    Given user is on the practice form page
    When user fills only mandatory details
    And submits the form
    Then success modal should appear

  Scenario: Submit with valid picture upload
    Given user is on the practice form page
    When user fills mandatory details and uploads picture
    And submits the form
    Then success modal should appear

  Scenario: Submit selecting multiple hobbies
    Given user is on the practice form page
    When user fills mandatory details and selects hobbies
    And submits the form
    Then success modal should appear

  Scenario: Submit with valid edge mobile number "9999999999"
    Given user is on the practice form page
    When user fills mandatory details with mobile "9999999999"
    And submits the form
    Then success modal should appear

  # Negative Scenarios
  Scenario: Submit without mandatory details
    Given user is on the practice form page
    When user leaves mandatory details blank
    And submits the form
    Then error should be displayed

  Scenario: Submit with invalid email "invalidEmail"
    Given user is on the practice form page
    When user fills with invalid email "invalidEmail"
    And submits the form
    Then error should be displayed

  Scenario: Submit with short mobile number "12345"
    Given user is on the practice form page
    When user fills with mobile "12345"
    And submits the form
    Then error should be displayed

  Scenario: Submit with future date of birth
    Given user is on the practice form page
    When user selects future date of birth
    And submits the form
    Then error should be displayed

  Scenario: Submit without selecting gender
    Given user is on the practice form page
    When user fills everything except gender
    And submits the form
    Then error should be displayed
