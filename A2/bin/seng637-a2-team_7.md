**SENG 637 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group #: 07      |
| ---------------- |
| Benjamin Reid    |
| Carissa Chung    |
| Christian Valdez |
| Alton Wong       |
| Braden Tink      |

# 1) Introduction

To increase our knowledge of software testing (and Java in particular), we are looking at Junit testing. This is a common technique to test Java code using the built-in functionality. The JFreeChart .jar files were provided for this assignment, and will be used as example classes for testing.

# 2) Detailed description of unit test strategy

### Overview

We're testing two classes:

- `Range`: Deals with numeric ranges.
- `DataUtilities`: Handles data set operations.

We'll use JUnit 4 for tests and jMock for mocking.

### Test Strategies

1. **Equivalence Class Testing**

   - Test different types of valid inputs as representatives of larger groups.
   - For `Range`: Positive, negative, and zero values.
   - For `DataUtilities`: Various dataset sizes and value types.

2. **Boundary Value Analysis**

   - Focus on the edge cases for inputs.
   - For `Range`: Test the exact start and end points.
   - For `DataUtilities`: Test with minimum and maximum size datasets.

3. **Robustness Testing**

   - Check how the system handles slightly out-of-range inputs.
   - Test `Range` and `DataUtilities` with inputs just outside expected ranges.

4. **Worst Case Testing**
   - Test with the most complex or extreme input scenarios.
   - Combine multiple operations or use extreme values.

### Mocking Strategy

- Use jMock for `Values2D` and `KeyedValues` in `DataUtilities`.
- Example:
  ```java
  Mockery context = new Mockery();
  final Values2D values = context.mock(Values2D.class);
  ```
- Note: Mocking focuses on method interactions, not full behavior.

### Test Case Development

- Write clear, single-purpose test cases.
- Name tests descriptively, e.g., `testPositiveRangeValues`, `testDataUtilitiesWithEmptyDataset`.

### Execution & Review

- Run tests against `jfreechart-1.0.19.zip`.
- Expect some failures due to intentional defects.
- Review and adjust tests as needed based on results.

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
  - **Status**: Fail, got 1.0

- **testNegativeShiftLowerBound**

  - **Objective**: Confirm that the lower bound correctly decreases by the shift value for a negative shift.
  - **Input**: Negative shift of -2
  - **Expected Outcome**: Lower bound should be -3.
  - **Status**: Pass

- **testNegativeShiftUpperBound**

  - **Objective**: Verify that the upper bound correctly decreases by the shift value for a negative shift.
  - **Input**: Negative shift of -2
  - **Expected Outcome**: Upper bound should be -1.
  - **Status**: Fail, ,got -1.0

- **testNoShiftLowerBound**

  - **Objective**: Test that the lower bound remains unchanged with a shift of 0.
  - **Input**: No shift (0)
  - **Expected Outcome**: Lower bound remains -1.
  - **Status**: Pass

- **testNoShiftUpperBound**

  - **Objective**: Ensure the upper bound remains unchanged with a shift of 0.
  - **Input**: No shift (0)
  - **Expected Outcome**: Upper bound remains 1.
  - **Status**: Fail, got -1.0

- **testShiftWithLargeDeltaLowerBound**

  - **Objective**: Evaluate the method's behavior with a significantly large shift value.
  - **Input**: Large shift of 1000000
  - **Expected Outcome**: 999999
  - **Status**: Pass

- **testShiftWithLargeDeltaUpperBound**

  - **Objective**: Evaluate the method's behavior with a significantly large shift value.
  - **Input**: Large shift of 1000000
  - **Expected Outcome**: 1000001
  - **Status**: Fail, got 999999

- **testShiftedLength**

  - **Objective**: Confirm that the size of the range remains constant after shifting.
  - **Input**: Positive shift of 2
  - **Expected Outcome**: Range size (length) remains constant at 2.0.
  - **Status**: Fail, got 0.0

- **testPositiveShiftedCentralValue**

  - **Objective**: Verify that the central value of the range is correctly shifted.
  - **Input**: Positive shift of 2
  - **Expected Outcome**: Central value should be 2.
  - **Status**: Fail, got 1.0

- **testPositiveShiftedIntersect**

  - **Objective**: Test if the shifted range correctly intersects with a specified range.
  - **Input**: Positive shift of 2; test intersect with range 1 to 3
  - **Expected Outcome**: Should intersect.
  - **Status**: Pass

- **testPositiveShiftedNoIntersect**

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
  - **Status**: Fail, resulted precision loss

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
  - **Status**: Fail, got 3.5

### DataUtilities Class Tests

#### calculateRowTotal Method Testing

The `calculateRowTotal` method was examined under various conditions to ensure its capability to accurately sum row values.

- **testCalculateRowTotalWithValidData**

  - **Objective**: Verify accurate row total calculation with valid row data.
  - **Input**: Mock `Values2D` object with 3 values in a row (1.0, 2.0, 3.0).
  - **Expected Outcome**: The method should correctly calculate the total as 6.0.
  - **Status**: Fail, got 3.0

- **testCalculateRowTotalWithNullData**

  - **Objective**: Assess method's response to null data input.
  - **Input**: `null` as the data source.
  - **Expected Outcome**: The method should throw an `NullPointerException`.
  - **Status**: Pass

- **testCalculateRowWithInvalidRow**
  - **Objective**: Evaluate the method's handling of an invalid row index.
  - **Input**: Mock `Values2D` object representing 1 row, with an attempt to calculate total for a non-existing row (row index 1).
  - **Expected Outcome**: The method should return a total of 0.0, indicating no valid row was processed.
  - **Status**: Pass

# 4) How the team work/effort was divided and managed

To let all group members gain experience with Junit, each member was assigned a method from both classes. Once testing files were created, the other members reviewed the files to ensure all testing cases from the javadocs were fully tested. All information was then added to the report markdown file.

# 5) Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6) Comments/feedback on the lab itself

Text…
