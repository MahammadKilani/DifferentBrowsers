@RunMe
  Feature: Test Titles
    Scenario: Test using Microsoft Edge
      When user opens "Microsoft Edge"
      And Navigates to HomePage URL
      And Clicks on First Page
      And Clicks on Second Page
      Then He could see the Name in Every Page