Feature: Is it Friday yet?
  Everybody wants to know when it's Friday
#  Scenario: Sunday isn't Friday
#    Given today is Sunday
#    When I ask whether it's Friday yet
#    Then I should be told "Nope"
  Scenario: find kitten images on google

    Given we can open google

    When we search for kittens

    Then google will return us images of kittens


  Scenario: find puppies images on google

    Given we can open re-open google

    When we search for puppies

    Then google will return us images of "puppies"