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

- **Objective**: Error out on Values2D data
- **Input**: `data = null`, `column = 6`, `validRows = 9`.
- **Expected Result**: The method throws an exception for the null `data` object.

| Test Case               | Execution Path | DU Pairs | Coverage |
| ----------------------- | -------------- | -------- | -------- |
| Check for null Values2D |                |          | 64.7%    |

**Test Case 2: Data with an empty array of validRows**

- **Objective**: To cover the scenario where the loop does not iterate even once.
- **Input**: `data = positive 2D matrix`, `column = 6`, `validRows = empty array`.
- **Expected Result**: The method returns `0.0`.

| Test Case               | Execution Path | DU Pairs | Coverage |
| ----------------------- | -------------- | -------- | -------- |
| Check for null Values2D |                |          | 100%     |

**Test Case 3: Data with validRows containing indices higher than rowCount**

- **Objective**: To the case where the theres is more valid rows than matrix.
- **Input**: `data = positive 2D matrix`, `column = 6`, `validRows > data.getRowCount()`.
- **Expected Result**: The method returns `0.0` because the condition `row < rowCount` is false.

| Test Case               | Execution Path | DU Pairs | Coverage |
| ----------------------- | -------------- | -------- | -------- |
| Check for null Values2D |                |          | 20%      |

**Test Case 4: Data with validRows and some null values**

- **Objective**: To cover the false branch of the condition `if (n != null)`.
- **Input**: `data = positive 2D matrix will null rows`, `column = 6`, `validRows <= data.getRowCount()`.
- **Expected Result**: The method returns the sum of the non-null values in the specified column for the validRows.

| Test Case               | Execution Path | DU Pairs | Coverage |
| ----------------------- | -------------- | -------- | -------- |
| Check for null Values2D |                |          | 100%     |

**Test Case 5: Data with validRows and valid values 2D**

- **Objective**: To cover all lines.
- **Input**: `data = positive 2D matrix`, `column = 6`, `validRows <= data.getRowCount()`.
- **Expected Result**: The method returns the sum of the column for the validRows.

| Test Case               | Execution Path | DU Pairs | Coverage |
| ----------------------- | -------------- | -------- | -------- |
| Check for null Values2D |                |          | 100%     |
