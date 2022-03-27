
Feature: Login

Scenario: Login with invaild credentials 
	
	Given I am on "https://www.nobroker.in/" in "Chrome" browser
	
	And  Click on login
	
	Then entering phone number "6302063076" and passord as "kris1186"
	
	And click on sigin in
	
	Then it must not log into account