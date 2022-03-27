
Feature: Rent search

Scenario: Searching rent

	Given I am on "https://www.nobroker.in/" in "Chrome" browser
	
	And  selct emi option
	
	Then enter vales Loan_Amount "1,000" Rate_of_Interest "50" and Loan_Tenure "20"
	
	Then it must show Monthly EMI "42" Principal_Amount "1,000" TotalInterest "9,080" and Total Amount "10,080"
	