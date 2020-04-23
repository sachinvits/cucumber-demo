Feature: Google Search

	Scenario: Navigate to Google and Search
	Given Navigate to URL "http://www.google.com"
	Then Find search textbox "q"
	Then Enter search keyword "Cheese"
	When Submit search
	Then Verify search results