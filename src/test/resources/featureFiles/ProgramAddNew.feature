Feature: Program Module Add new Program Functionality

Background: 
Given Admin is on home page after Login

@addnewprogram
   Scenario: Verify add New Program
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see pop up window for program details

@popuptitle
    Scenario: Verify title of the pop up window
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see window title as "Program Details"

@redasteriskmark
    Scenario: Verify mandatory fields with red asterisk mark
    Given Admin is on Program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see red asterisk mark beside mandatory field Name


@filedisrequired     
   Scenario Outline: Verify empty form submission for mandatory fields
    Given Admin is on Program details form
    When Admin clicks save button without entering mandatory
    Then Admin gets message "<Field>" is required

Examples:
    | Field       |
    | Program name |
    | Description |
    | Status      | 
    @verifycancelbutton
    Scenario: Verify cancel button
    Given Admin is on Program details form
    When Admin clicks Cancel button
    Then Admin can see Program Details form disappears
   
    @entertextinfield
    Scenario Outline: Verify text entry in different fields
    Given Admin is on Program details form
    When Admin enters "<FieldValue>" in the "<FieldName>" text box and click on save button
    Then Admin can see the entered text in "<FieldName>" box

Examples:
    | FieldName   | FieldValue                  |
    | Name        | Sample Program              |
    | Description | This is a test description. |
   
    @activeinactivestatus
    Scenario Outline: Verify selecting a status option
    Given Admin is on Program details form
    When Admin selects the status of the program by clicking on the radio button "<Status>"
    Then Admin can see "<Status>" status selected

Examples:
    | Status    |
    | Active    |
    | Inactive  |
      
   # @alldetails 
    #Scenario: Verify Admin is able to save the program details
    #Given Admin is on Program details form
    #When Admin enter valid details for mandatory fields and Click on save button
    #Then Admin gets message 'Program created Successful'
    @searchnewlyadded
    Scenario: Verify added Program is created
    Given Admin is on Program page
    When Admin searches with newly created "Listeners"
    Then Records of the newly created "Listeners" is displayed and match the data entered
    @closeX
     Scenario: Verify close window with "X"
    Given Admin is on Program details form
    When Admin Click on X button
    Then Admin can see Program Details form disappears