@search
Feature: Library app search feature
  As a user, I should be able to login as librarian. When I go to Users page,
  table should have the columns.

  Scenario: Table columns names
    Given user is on the library login page
    When librarian enters "librarian2@library" and "eb2VQKEj"
    And librarian clicks on "Users" link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |