Feature: Creating a calculator application
	Scenario: Invoking addition
		Given A Rest calculator api "http://localhost:8080/addition?firstOperand=10&secondOperand=20"
		When invoking rest api for addition
		Then expecting result as 30
