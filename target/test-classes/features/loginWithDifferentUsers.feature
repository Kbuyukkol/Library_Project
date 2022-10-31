
Feature: Library app login feature
  As a user, I should be able to login with different
  accounts. When I login, I should be able to see username in the account username section.

  Scenario Outline: Verify user information <email>
    Given user is on the library login page
    When librarian enters "<email>" and "<password>"
    Then account holder name should be "<name>"
    Examples:
      | email              | password | name             |
      | librarian1@library | rs4BNN9G | Test Librarian 1 |
      | librarian2@library | eb2VQKEj | Test Librarian 2 |
      | librarian3@library | I6JMMwLb | Test Librarian 3 |




