
Feature: Footer

Scenario: Searching loaction in footer pg hostel
	
	Given I am on "https://www.nobroker.in/" in "Chrome" browser
	
	And click on pghostels in footer
	
	Then Verify it contains "Powai" 
	
	