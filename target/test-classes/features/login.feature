Feature: Login

@stable
Scenario: Login using properties file input data
	Given we are on login page
	When we enter credentials
	Then we should be able to login successfully
	
@login
Scenario Outline: Login using feature file input data
	Given we are on login page
	When we enter credentials "<username>" and "<password>"
	Then we should be able to login successfully
Examples:
	|username|password|
	|yddhanuka@gmail.com|tapl3005|