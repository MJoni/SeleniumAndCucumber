Feature: googleTest

  ==============================
  ===	Information:
  An example of how we can use scenario outline with the examples keyword to declare
  a table header and pass each entry to our scenario.

  @mytag
  Scenario Outline: find "<Animals>" images on google
    Given we can open google site
    When we search for "<Animals>"
    Then google will return us image of "<Animals>"

    Examples:
      | 	Animals	|
      | 	kittens	|
      | 	puppies |