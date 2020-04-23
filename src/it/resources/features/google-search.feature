Feature: Perform Google Search with keywords

	Scenario: In a web browser, user navigates to Google web page and performs search
	Given A web browser
	Then User navigates to URL "http://www.google.com"
	Then on web page find search box
	And user enters search keyword "Cheese"
	And user submits the page to perform search
	Then verify that page displays search results for "Cheese"