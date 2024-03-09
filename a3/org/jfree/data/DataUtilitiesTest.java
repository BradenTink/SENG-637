package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.*;
import org.jmock.*;

public class DataUtilitiesTest {
    private Mockery mockingContext;
    private Values2D values;
    private KeyedValues kv;
    
    @Before
    public void setUp() throws Exception {
        this.mockingContext = new Mockery();
        this.values = this.mockingContext.mock(Values2D.class);
        this.kv = mockingContext.mock(KeyedValues.class);
    }
    
 // test cases for calculateColumnTotal(Values2D data, int column, int[] validRows) ------------------------
	@Test
    public void columnTotalWithRows3x3Test() {
    	final int column = 1;
    	final int[] validRows = {0, 1, 2};
    	
        mockingContext.checking(new Expectations() {{
			// Setup 3 rows
			oneOf(values).getRowCount(); will(returnValue(3));
			
			// Setup 3 columns
			oneOf(values).getColumnCount(); will(returnValue(3));
            
			// Mocking the behavior for 3 rows and a specific column
            oneOf(values).getValue(0, column); will(returnValue(2.5));
            oneOf(values).getValue(1, column); will(returnValue(3.0));
            oneOf(values).getValue(2, column); will(returnValue(4.5));
        }});
        double result = DataUtilities.calculateColumnTotal(values, column, validRows);
        assertEquals("The column total should be 10.0", 10.0, result, 0.00001d);
    }
}
