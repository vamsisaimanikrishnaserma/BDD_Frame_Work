
Feature: Login

Scenario: Login with vaild credentials 
	
	Given I am on "https://www.nobroker.in/" in "Chrome" browser
	
	And  Click on login
	
	Then entering phone number "6302063076" and password as "kris1186"
	
	And click on sigin in
	
	Then it must login into account