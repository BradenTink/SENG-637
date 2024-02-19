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
  - **Input**: 2
  - **Expected Outcome**: 1.0
  - **Status**: Pass

- **testAtHighConstrain**

  - **Objective**: Validate the `constrain` method's functionality at the upper boundary of the range.
  - **Input**: Value = 1
  - **Expected Outcome**: 1.0
  - **Status**: Pass

- **testBelowConstrain**

  - **Objective**: Assess the `constrain` method's handling of values below the range.
  - **Input**: -2
  - **Expected Outcome**: -1.0
  - **Status**: Fail

- **testAtLowConstrain**

  - **Objective**: Test the `constrain` method's performance at the lower boundary of the range.
  - **Input**: Value = -1
  - **Expected Outcome**: -1.0
  - **Status**: Pass

- **testInsideConstrain**

  - **Objective**: Check the `constrain` method's effectiveness for values within the range.
  - **Input**: 0.0
  - **Expected Outcome**: 0.0
  - **Status**: Pass

- **testDecimalInsideConstrain**
  - **Objective**: Verify the `constrain` method's functionality for decimal values within the range.
  - **Input**: 0.5
  - **Expected Outcome**: 0.5
  - **Status**: Pass

#### Shift Method Testing

The `shift` method was assessed through various tests to verify its capability to correctly adjust the range of values, with a focus on ensuring that the method behaves as expected under a wide array of conditions.

- **testPositiveShiftLowerBound**

  - **Objective**: Verify that the lower bound correctly increases by the shift value for a positive shift.
  - **Input**: Positive shift of 2
  - **Expected Outcome**: Lower bound should be 1.
  - **Status**: Pass

- **testPositiveShiftUpperBound**

  - **Objective**: Ensure that the upper bound correctly increases by the shift value for a positive shift.
  - **Input**: Positive shift of 2
  - **Expected Outcome**: Upper bound should be 3.
  - **Status**: Fail

- **testNegativeShiftLowerBound**

  - **Objective**: Confirm that the lower bound correctly decreases by the shift value for a negative shift.
  - **Input**: Negative shift of -2
  - **Expected Outcome**: Lower bound should be -3.
  - **Status**: Pass

- **testNegativeShiftUpperBound**

  - **Objective**: Verify that the upper bound correctly decreases by the shift value for a negative shift.
  - **Input**: Negative shift of -2
  - **Expected Outcome**: Upper bound should be -1.
  - **Status**: Fail

- **testNoShiftLowerBound**

  - **Objective**: Test that the lower bound remains unchanged with a shift of 0.
  - **Input**: No shift (0)
  - **Expected Outcome**: Lower bound remains -1.
  - **Status**: Pass

- **testNoShiftUpperBound**

  - **Objective**: Ensure the upper bound remains unchanged with a shift of 0.
  - **Input**: No shift (0)
  - **Expected Outcome**: Upper bound remains 1.
  - **Status**: Fail

- **testShiftWithLargeDelta**

  - **Objective**: Evaluate the method's behavior with a significantly large shift value.
  - **Input**: Large shift of 1000000
  - **Expected Outcome**: Correctly adjusted bounds for a large shift.
  - **Status**: Fail

- **testShiftedLength**

  - **Objective**: Confirm that the size of the range remains constant after shifting.
  - **Input**: Positive shift of 2
  - **Expected Outcome**: Range size (length) remains constant at 2.0.
  - **Status**: Fail

- **testCentralValue**

  - **Objective**: Verify that the central value of the range is correctly shifted.
  - **Input**: Positive shift of 2
  - **Expected Outcome**: Central value should be 2.
  - **Status**: Fail

- **testIntersect**

  - **Objective**: Test if the shifted range correctly intersects with a specified range.
  - **Input**: Positive shift of 2; test intersect with range 1 to 3
  - **Expected Outcome**: Should intersect.
  - **Status**: Pass

- **testNoIntersect**

  - **Objective**: Assess if the shifted range does not intersect with a specified range where it shouldn't.
  - **Input**: Positive shift of 2; test intersect with range 4 to 6
  - **Expected Outcome**: Should not intersect.
  - **Status**: Pass

- **testRepeatedShifts**

  - **Objective**: Verify that shifting a range right and then back left returns it to its original bounds.
  - **Input**: Initial range shifted right by 200 and then left by 200
  - **Expected Outcome**: Original bounds are restored.
  - **Status**: Pass

- **testShiftToDoubleLimits**
  - **Objective**: Evaluate the shift method's ability to handle shifts that approach the limits of double precision.
  - **Input**: Base range near double precision limit; shift of 1e307
  - **Expected Outcome**: Range does not collapse to a point after shift.
  - **Status**: Fail

### DataUtilities Class Tests

#### calculateColumnTotal Method Testing

The `calculateColumnTotal` method was examined under various conditions to ensure accurate summation capabilities.

- **calculateColumnTotalForTwoValues**

  - **Objective**: Confirm normal operation with two positive values.
  - **Input**: {7.5, 2.5}
  - **Expected Outcome**: 10.0
  - **Status**: Pass

- **calculateColumnTotalForThreeValues**

  - **Objective**: Test the method's ability to sum three positive values.
  - **Input**: {7.5, 2.5, 5.0}
  - **Expected Outcome**: 15.0
  - **Status**: Pass

- **calculateColumnTotalForNegativeValues**

  - **Objective**: Evaluate the method's handling of two negative values.
  - **Input**: {-5.0, -2.2}
  - **Expected Outcome**: -7.2
  - **Status**: Pass

- **calculateColumnTotalForWrongInput**
  - **Objective**: Check if the method adheres to Javadoc specifications when input is incorrect.
  - **Input**: {null, -2.5}
  - **Expected Outcome**: Method returns 0.
  - **Status**: Fail

# 4) How the team work/effort was divided and managed

To let all group members gain experience with Junit, each member was assigned a method from both classes. Once testing files were created, the other members reviewed the files to ensure all testing cases from the javadocs were fully tested. All information was then added to the report markdown file.

# 5) Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6) Comments/feedback on the lab itself

Text…
