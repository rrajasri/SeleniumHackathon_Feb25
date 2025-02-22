Feature: Program Module Add new Program Functionality

Background: 
Given Admin is on home page after Login


@Editform
Scenario: Verify Edit option
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin lands on Program details form
    
    @editpagetitle
    Scenario: Verify title of the pop up window
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin should see editwindow title as "Program Details"
    
    @redastrickinedit
    Scenario: Verify mandatory fields with red asterisk mark
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin should see red asterisk mark beside mandatory field Name
    
    #@editentertextinfield
    #Scenario Outline: Verify text entry in different fields
    #Given Admin is on Program page
    #When Admin edits "<FieldValue>" in the "<FieldName>" text box and click on save button
    #Then Admin can see the entered text in "<FieldName>" box
#
#Examples:
    #| FieldName   | FieldValue                  |
    #| Name        | Sample Programs             |
    #| Description | test description.           |
    @tag1
    Scenario: Verify Admin is able to click Cancel
    Given Admin is on Program details form
    When Admin clicks Cancel button
    Then Admin can see Program Details form disappears
    @tag2
    Scenario: Verify close the window with "X"
    Given Admin is on Program details form
    When Admin Click on X button
    Then Admin can see Program Details form disappears
    
    
    