@regression
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different
  accounts. And dashboard should be displayed.

  Accounts are: librarian, student

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the library login page


  @librarian
  Scenario: Login as librarian
    When librarian enters "librarian2@library"
    And librarian enters the "eb2VQKEj"
    Then librarian should see the dashboard

  @student
  Scenario: Login as student
    When student enters "student2@library"
    And student enters the "80qynl9d"
    Then student should see the dashboard


  @librarian2
  Scenario: Login as librarian in the same line
    When librarian enters "librarian2@library" and "eb2VQKEj"
    Then librarian should see the dashboard
    And there should be 173 users


  @student2
  Scenario: Login as student in the same line
    When student enters email and password
    Then student should see the dashboard
    Then account holder name should match
