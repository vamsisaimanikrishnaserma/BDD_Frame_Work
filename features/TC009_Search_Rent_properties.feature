
Feature: Rent search

Scenario: Searching rent

	Given I am on "https://www.nobroker.in/" in "Chrome" browser
	
	And  selct rent option
	
	Then Search for "Taj Lands End, Mumbai, Byramji Jeejeebhoy Road, Mount Mary, Bandra West, Mumbai, Maharashtra, India "
	
	And verify no reuslt in rent "36"
	