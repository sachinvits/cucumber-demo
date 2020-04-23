Feature: As an Administrator, the application should allow me to add new user, update existing user, get an user and remove user.
		
	Scenario: Administrator opens User management application and adds a User with details such as user id, user name, first name, last name and email address.
		Given On User management page Administrator adds a new user with following fields:
    		| fieldName | fieldValue			|
    		| id 		| 100 					|
    		| userName 	| tomhanks 				|
    		| firstName | Tom 					|
    		| lastName 	| Hanks 				|
    		| email 	| tom.hanks@gmail.com 	|
		When Administrator saves this new user 
		Then application shows below message on the page:
		""" 
		User having id=100, saved successfully
		"""	
		
		