Feature: User CRUD Operations
  Scenario Outline: Create User
    Given Create User using below data:
      | id  | userName | firstName | lastName | email |
      | 100 | tomhanks | Tom       | Hanks    | tom.hanks@gmail.com |
    When Saved successfully
    Then the output should return <userName>