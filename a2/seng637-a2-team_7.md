**SENG 637 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#: 7      |     |
| ---------------- | --- |
| Student Names:   |     |
| Benjamin Reid    |     |
| Carissa Chung    |     |
| Christian Valdez |     |
| Alton Wong       |     |
| Braden Tink      |     |

# 1) Introduction

To increase our knowledge of software testing (and Java in particular), we are looking at Junit testing. This is a common technique to test Java code using the built-in functionality. The JFreeChart .jar files were provided for this assignment, and will be used as example classes for testing.

# 2) Detailed description of unit test strategy

// including the input partitions you have designed

To properly test the provided software, we will be unit testing the Range and DataUtilites classes. Each of these classes has several methods which will be tested (5 from each). Black box testing will be used, so the javadoc information will be used to design the tests to ensure all the functionality is met. The javadoc explains how the methods should function, so the test cases can try this functionality to determine if the method works as intended. For example, when looking at a range of values we will test above and below this range, at the limits of this range, and within the bounds of the range to ensure all criteria are met.

# 3) Test cases developed

### Range Class Tests

#### Constrain Method Testing

The `constrain` method was tested across various scenarios to ensure its functionality within and outside the defined range of -1 to 1.

- **testAboveConstrain**

  - **Objective**: Verify the `constrain` method handles values above the range.
  - **Input**: Value > 1
  - **Expected Outcome**: Method operates correctly.
  - **Status**: Pass

- **testAtHighConstrain**

  - **Objective**: Validate the `constrain` method's functionality at the upper boundary of the range.
  - **Input**: Value = 1
  - **Expected Outcome**: Method operates correctly.
  - **Status**: Pass

- **testBelowConstrain**

  - **Objective**: Assess the `constrain` method's handling of values below the range.
  - **Input**: Value < -1
  - **Expected Outcome**: Method should correctly handle the value.
  - **Status**: Fail

- **testAtLowConstrain**

  - **Objective**: Test the `constrain` method's performance at the lower boundary of the range.
  - **Input**: Value = -1
  - **Expected Outcome**: Method operates correctly.
  - **Status**: Pass

- **testInsideConstrain**

  - **Objective**: Check the `constrain` method's effectiveness for values within the range.
  - **Input**: -1 < Value < 1
  - **Expected Outcome**: Method operates correctly.
  - **Status**: Pass

- **testDecimalInsideConstrain**
  - **Objective**: Verify the `constrain` method's functionality for decimal values within the range.
  - **Input**: Decimal value between -1 and 1
  - **Expected Outcome**: Method operates correctly.
  - **Status**: Pass

### DataUtilities Class Tests

#### calculateColumnTotal Method Testing

The `calculateColumnTotal` method was examined under various conditions to ensure accurate summation capabilities.

- **calculateColumnTotalForTwoValues**

  - **Objective**: Confirm normal operation with two positive values.
  - **Input**: Two positive values
  - **Expected Outcome**: Correct sum calculated.
  - **Status**: Pass

- **calculateColumnTotalForThreeValues**

  - **Objective**: Test the method's ability to sum three positive values.
  - **Input**: Three positive values
  - **Expected Outcome**: Correct sum calculated.
  - **Status**: Pass

- **calculateColumnTotalForNegativeValues**

  - **Objective**: Evaluate the method's handling of two negative values.
  - **Input**: Two negative values
  - **Expected Outcome**: Correct sum calculated.
  - **Status**: Pass

- **calculateColumnTotalForWrongInput**
  - **Objective**: Check if the method adheres to Javadoc specifications when input is incorrect.
  - **Input**: Invalid input
  - **Expected Outcome**: Method returns 0.
  - **Status**: Fail

# 4) How the team work/effort was divided and managed

To let all group members gain experience with Junit, each member was assigned a method from both classes. Once testing files were created, the other members reviewed the files to ensure all testing cases from the javadocs were fully tested. All information was then added to the report markdown file.

# 5) Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6) Comments/feedback on the lab itself

Text…
