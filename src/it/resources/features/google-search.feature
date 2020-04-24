Feature: Perform Google Search with keywords

	Scenario: In a web browser, user navigates to Google web page and performs search
	Given In a web browser user navigates to URL "google.search.url"
	Then user enters keyword "google.search.keyword" in search box
	Then user submits the page to perform search
	Then verify that page displays search results for keyword "google.search.keyword" with message: 
	"""
	google.search.results.message
	""" 