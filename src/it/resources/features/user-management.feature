Feature: As an Administrator, the application should allow me to add new user, update existing user, get an user and remove user.
		
	Scenario: Administrator opens User management application and adds a User.
		Given On User management page Administrator adds a new user with details:"user.mgmt.add.userdetails"
		When Administrator saves this new user 
		Then application shows below message on the page:
		""" 
		user.mgmt.add.successmsg
		"""			