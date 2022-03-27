
Feature: Login

Scenario: Logging and verifying details
	
	Given I am on "https://www.nobroker.in/" in "Chrome" browser
	
	And loggged in with phone number "6302063076" and passord as "kris1186"
	
	Then it shoul show name as "VamsiKrishna" phoneNumber as "6302063076" and email "vamsikrishnak05@gmail.com"
