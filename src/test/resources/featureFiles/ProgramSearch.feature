Feature: Program Module Add new Program Functionality

Background: 
Given Admin is on home page after Login

@search1
Scenario Outline: Verify Admin is able to search results found for program name
    Given Admin is on Program page
    When Admin enter the program to search By program name "<Sheetname>" and <RowNumber>
    Then Admin should able to see Program name, description, and status for searched program name
    Examples:
    | Sheetname    | RowNumber |
    | tryEditor    |  1        |
#
    #Scenario: Verify Admin is able to search results found for program description
    #Given Admin is on Program page
    #When Admin enter the program to search By program description
    #Then Admin should able to see Program name, description, and status for searched program description
#
    #Scenario: Verify Admin is able to search results not found
    #Given Admin is on Program page
    #When Admin enter the program to search By program name that does not exist
    #Then There should be zero results.
#
    #Scenario: Verify Admin is able to search with partial program name
    #Given Admin is on Program page
    #When Admin enter the program to search By partial name of program
    #Then Admin should able to see Program name, description, and status for searched program name
#










@graph9
Scenario Outline: Verify that user is able to run valid Python code in Try Editor for Graph Page
  Given The user is on the tryeditor page of Graph module
  When The user enters code "<code>", "<Sheetname>" and <RowNumber> clicks the Run button
  Then The user should see an result "<expectedresult>", "<Sheetname>" and <RowNumber>
  Examples:
    | Sheetname    | RowNumber |code     |expectedresult      |
    | tryEditor    |  1        | Valid   |  successouput      |           
    | tryEditor    |  1        | Invalid |alertmessageoutput  |


