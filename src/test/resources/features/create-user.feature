Feature: User CRUD Operations

  Scenario: Create User with given details
    Given create user using following fields:
    	| fieldName | fieldValue			|
    	| id 		| 100 					|
    	| userName 	| tomhanks 				|
    	| firstName | Tom 					|
    	| lastName 	| Hanks 				|
    	| email 	| tom.hanks@gmail.com 	|
    	

    When Saved successfully
    Then the output should return <userName>