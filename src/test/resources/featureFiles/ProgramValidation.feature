Feature: Program functionality

Background: 
Given Admin is on home page after Login
    
    @navigationtoprogrampage
    Scenario: Verify that Admin is able to navigate to Program page
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should be navigated to Program page
    
    @Logout
    Scenario: Verify Logout displayed in menu bar
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see Logout in menu bar
    
    @verifyheading
    Scenario: Verify heading in menu bar
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the heading "LMS - Learning Management System"

    @verifymenuorder
    Scenario: Verify other pages name displayed in menu bar
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the page names as in order "Home Program Batch Class"

    #Scenario: Verify sub menu displayed in program menu bar
    #Given Admin is on program page
    #When Admin clicks Program on the navigation bar
    #Then Admin should see sub menu in menu bar as "Add New Program"
    
    @verifymanageheading
    Scenario: Verify heading in manage program
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the heading as "Manage Program"
    
    @verifytablecolumns
    Scenario: Verify view details of programs
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should able to see Program name, description, and status for each program

    @multipledeletebuttondisabled
    Scenario: Verify the Multiple Delete button state
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see a Delete button in left top is disabled

    @searchbarwithtextsearch
    Scenario: Verify the Search button
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see Search bar displayed with text as "Search..."
   
    @managecolumnheader
    Scenario: Verify column header name of data table
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see data table with column header on the Manage Program Page as "Program Name, Program Description, Program Status, Edit / Delete"

    @verifycheckbox
    Scenario: Verify checkbox default state beside Program Name column header
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see checkbox default state as unchecked beside Program Name column header

    @verifycheckboxbesideprograms
    Scenario: Verify checkboxes default state beside each Program names in the data table
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see check box default state as unchecked on the left side in all rows against program name 
    @verifyarrowbesidecolumnheader
    Scenario: Verify Sort icon in manage program
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

    @editanddeleteoneachrow
    Scenario: Verify edit and delete icon in manage program
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table

    @Paginationformat
    Scenario: Verify pagination icons below data table in manage program
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table. x- starting record number on that pagey-ending record number on that pagez-Total number of records

    @footermessage
    Scenario: Verify footer message in manage program
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the footer as In total there are z programs.z- Total number of records

   


#
    #Scenario: Verify Admin is able to save the program details
    #Given Admin is on program details form
    #When Admin enter valid details for mandatory fields and Click on save button
    #Then Admin gets message 'Successful Program created'

#
    #Scenario: Verify added Program is created
    #Given Admin is on Program page
    #When Admin searches with newly created "Program Name"
    #Then Records of the newly created "Program Name" is displayed and match the data entered

  #----------------------------------------------------------------



#
    #Scenario: Verify edit Program Name
    #Given Admin is on Program page
    #When Admin edits the program name and click on save button
    #Then Updated program name is seen by the Admin
#
    #Scenario: Verify edit Description
    #Given Admin is on Program page
    #When Admin edits the description text and click on save button
    #Then Admin can see the description is updated
#
    #Scenario: Verify edit Status
    #Given Admin is on Program page
    #When Admin can change the status of the program and click on save button
    #Then Status updated can be viewed by the Admin
#
    #Scenario: Verify Admin is able to click Save
    #Given Admin is on Program page
    #When Admin click on save button
    #Then Admin can see the updated program details

#
    #Scenario: Verify edited Program details
    #Given Admin is on Program page
    #When Admin searches with newly updated "Program Name"
    #Then Admin verifies that the details are correctly updated.

    
    #-------------------------------------------------------------------







   

#
    #Scenario: Verify Admin is able to search results found for program name
    #Given Admin is on Program page
    #When Admin enter the program to search By program name
    #Then Admin should able to see Program name, description, and status for searched program name
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
    #Scenario: Verify sorting of Program name inAscending order/Descending order
    #Given Admin is on Program page
    #When Admin clicks on Arrow next to programName
    #Then Admin See the Program Name is sorted in Ascending order/Descending order
#
    #Scenario: Verify sorting of Program Descriptionin Ascending order/Descending order
    #Given Admin is on Program page
    #When Admin clicks on Arrow next to ProgramDescription
    #Then Admin See the program Description is sortedin Ascending order/Descending order
#
    #Scenario: Verify sorting of Program status inAscending order/Descending order
    #Given Admin is on Program page
    #When Admin clicks on Arrow next to Program status
#
    #Then Use See the Program Status is sorted in Ascending order/Descending order
#
    #Scenario: Verify Admin is able to click Next page link
    #Given Admin is on Program page
    #When Admin clicks Next page link on the program table
    #Then Admin should see the Pagination has "Next" active link
#
    #Scenario: Verify Admin is able to click Last page link
    #Given Admin is on Program page
    #When Admin clicks Last page link
    #Then Admin should see the last page record on the table with Next page link are disabled
#
    #Scenario: Verify Admin is able to click Previous page link
    #Given Admin is on last page of Program page table
    #When Admin clicks Previous page link
    #Then Admin should see the previous page record on the table with pagination has previous page link
#
    #Scenario: Verify Admin is able to click First page link
    #Given Admin is on Previous Program page
    #When Admin clicks First page link
    #Then Admin should see the very first page record on the table with Previous page link are disabled
#
    #Scenario: Verify pagination when there are no records
    #Given Admin is on home page after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should not see any pagination icons and message "No records found"
#
    #Scenario: Verify pagination when there are less than 5 records
    #Given Admin is on home page after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should see pagination icons disabled
#
