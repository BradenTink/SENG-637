| Index | DEF                     | USE               | Code                                                                                    |
| ----- | ----------------------- | ----------------- | --------------------------------------------------------------------------------------- |
| 1     | data, column, validRows |                   | `public static double calculateColumnTotal(Values2D data, int column, int[] validRows)` |
| 2     |                         | data              | `ParamChecks.nullNotPermitted(data, "data");`                                           |
| 3     | total                   |                   | `double total = 0.0;`                                                                   |
| 4     |                         | total             | `if (total > 0){`                                                                       |
| 5     | total                   |                   | `total = 100;`                                                                          |
| 6     | rowCount                | data              | `int rowCount = data.getRowCount();`                                                    |
| 7     | v                       | validRows         | `for (int v = 0; v < validRows.length; v++){`                                           |
| 8     | row                     | validRows, v      | `int row = validRows[v];`                                                               |
| 9     |                         | row, rowCount     | `if (row < rowCount) {`                                                                 |
| 10    | n                       | data, row, column | `Number n = data.getValue(row, column);`                                                |
| 11    | n                       | n                 | `if (n != null) {`                                                                      |
| 12    | total                   | total, n          | `total += n.doubleValue();`                                                             |
| 13    |                         | total             | `return total;`                                                                         |

**Test Case 1: Data with null Values2D object**

- **Objective**: To cover the null check at the beginning of the method.
- **Input**: `data = null`, `column = any valid integer`, `validRows = any valid int array`.
- **Expected Result**: The method throws an exception for the null `data` object.

**Test Case 2: Data with an empty array of validRows**

- **Objective**: To cover the scenario where the loop does not iterate even once.
- **Input**: `data = valid Values2D object with any number of rows`, `column = any valid integer`, `validRows = empty array`.
- **Expected Result**: The method returns `0.0`.

**Test Case 3: Data with validRows containing indices higher than rowCount**

- **Objective**: To cover the false branch of the condition `if (row < rowCount)`.
- **Input**: `data = valid Values2D object with 1 row`, `column = 0`, `validRows = array with elements greater than 1`.
- **Expected Result**: The method returns `0.0` because the condition `row < rowCount` is false.

**Test Case 4: Data with validRows and all non-null values**

- **Objective**: To cover the scenario where all data values are non-null and are summed.
- **Input**: `data = valid Values2D object with multiple rows`, `column = 0`, `validRows = array with valid row indices`.
- **Expected Result**: The method returns the sum of the values in the specified column for the validRows.

**Test Case 5: Data with validRows and some null values**

- **Objective**: To cover the false branch of the condition `if (n != null)`.
- **Input**: `data = valid Values2D object with multiple rows`, `column = 0`, `validRows = array with valid row indices where some rows contain null values`.
- **Expected Result**: The method returns the sum of the non-null values in the specified column for the validRows.

These test cases, when executed, should cover all the paths through the code:

- The null check (`ParamChecks.nullNotPermitted(data, "data")`).
- The initialization of `total` to `0.0`.
- The for-loop, including iterations where it processes and skips certain rows based on the `rowCount` check.
- The addition of non-null values to `total`.
- The return statement to exit the method with the correct total.
