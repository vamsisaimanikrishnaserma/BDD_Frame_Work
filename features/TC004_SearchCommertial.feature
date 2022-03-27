
Feature: Search

Scenario: Searching commertial
	
	Given I am on "https://www.nobroker.in/" in "Chrome" browser
	
	And  selct Commertail option
	
	Then Search for "Taj Lands End, Mumbai, Byramji Jeejeebhoy Road, Mount Mary, Bandra West, Mumbai, Maharashtra, India "
	
	And verify no reuslt "7"
	
	
	