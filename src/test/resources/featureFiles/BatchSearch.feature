Feature: Search Text box validation

Background: Admin is on the batch page


    Scenario: validate search box functionality
    Given Admin is on the batch page
    When Admin enters the batch name in the search text box
    Then Admin should see the filtered batches in the data table

