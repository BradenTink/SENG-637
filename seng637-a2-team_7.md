**SENG 637 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#: 7     |     |
| -------------- | --- |
| Student Names: |     |
| Benjamin Reid               |     |
| Carissa Chung               |     |
| Christian Valdez               |     |
| Alton Wong               |     |
| Braden Tink               |     |

# 1 Introduction

To increase our knowledge of software testing (and Java in particular), we are looking at Junit testing. This is a common technique to test Java code using the built-in functionality. The JFreeChart .jar files were provided for this assignment, and will be used as example classes for testing. 

# 2 Detailed description of unit test strategy

// including the input partitions you have designed

To properly test the provided software, we will be unit testing the Range and DataUtilites classes. Each of these classes has several methods which will be tested (5 from each). Black box testing will be used, so the javadoc information will be used to design the tests to ensure all the functionality is met. The javadoc explains how the methods should function, so the test cases can try this functionality to determine if the method works as intended. For example, when looking at a range of values we will test above and below this range, at the limits of this range, and within the bounds of the range to ensure all criteria are met. 

# 3 Test cases developed

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

Range Class:

  Constrain Method:

    The bounds of the range values used were -1 to 1, so the testing was done below -1, at -1 (the lower boundary), between the boundary values, at 1 (the upper boundary), and above 1.
  
    testAboveConstrain(): this checks to see if the constrain method works for a value above the given range (pass)
    testAtHighConstrain(): this checks to see if the constrain method works for the top boundary value in a given range (pass)
    testBelowConstrain(): this checks to see if the constrain method works for a value below the given range (fail)
    testAtLowConstrain(): this checks to see if the constrain method works for a the low boundary value in a given range (pass)
    testInsideConstrain(): this checks to see if the constrain method works for a value inside the given range (pass)
    testDecimalInsideConstrain(): this checks to see if the constrain method works for a decimal value inside the given range (pass)



DataUtilities Class:

  calculateColumnTotal Method:

    The method sums up the column, so testing was done with 2 values, more than 2 values, and negative values, the Javadoc also specifies that it returns 0 for an invalid input, so that was tested as well
  
    calculateColumnTotalForTwoValues(): this checks the function as it normally functions, with two positive values (pass)
    calculateColumnTotalForThreeValues(): this checks the extended function, with three positive values (pass)
    calculateColumnTotalForNegativeValues(): this checks the function, but with two negative values (pass)
    calculateColumnTotalForWrongInput(): this checks to see if method matches javadoc when input is not correct (fail)

# 4 How the team work/effort was divided and managed

To let all group members gain experience with Junit, each member was assigned a method from both classes. Once testing files were created, the other members reviewed the files to ensure all testing cases from the javadocs were fully tested. All information was then added to the report markdown file.

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
