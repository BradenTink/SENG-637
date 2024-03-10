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
    
	/********************************************************************
	 * ******************************************************************
	 * * Test Suite: calculateColumnTotal(Values2D, column) 			*
	 * * Tester: Ben, Chris                                             *
	 * ******************************************************************
	 ********************************************************************/
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateColumnTotalNullData() {
		final int column = 0;
		DataUtilities.calculateColumnTotal(null, column);
	}
	
	 @Test //to determine if the method can sum up a column of 2 values
	    public void calculateColumnTotalForTwoValues() {
	        // setup Mocking
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	
	        mockingContext.checking(new Expectations() {{
	            oneOf(values).getRowCount();
	            will(returnValue(2)); //Initializing 2 rows
	            oneOf(values).getValue(0, 0);
	            will(returnValue(7.5)); //Setting first value to 7.5
	            oneOf(values).getValue(1, 0);
	            will(returnValue(2.5)); //Setting second value to 2.5
	        }});
	
	        // exercise
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	
	        // verify
	        assertEquals(10.0, result, .000000001d);
	
	}
	 
	 @Test //to determine if the method can sum up negative values
	    public void calculateColumnTotalForNegativeValues() {
	        // setup Mocking
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	
	        mockingContext.checking(new Expectations() {{
	            oneOf(values).getRowCount();
	            will(returnValue(2)); //Initialize 2 rows
	            oneOf(values).getValue(0, 0);
	            will(returnValue(-5.0)); //Setting first value to -5.0
	            oneOf(values).getValue(1, 0);
	            will(returnValue(-2.2)); //Setting second value to -2.2
	        }});
	
	        // exercise
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	
	        // verify
	        assertEquals(-7.2, result, .000000001d);
	
	}
	
	@Test
	public void calculateColumnTotal() {
		final int column = 1;
		
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
	    
	    Double result = DataUtilities.calculateColumnTotal(values, column);
	    assertEquals("The column total should be 0.0", 10.0, result, 0.00001d);
	}
	
	@Test
	public void calculateColumnTotalWithNullData() {
		final int column = 1;
		
	    mockingContext.checking(new Expectations() {{
				// Setup 3 rows
				oneOf(values).getRowCount(); will(returnValue(3));
				// Setup 3 columns
				oneOf(values).getColumnCount(); will(returnValue(3));
				
				// Mocking the behavior for 3 rows and a specific column
	        oneOf(values).getValue(0, column); will(returnValue(2.5));
	        oneOf(values).getValue(1, column); will(returnValue(null));
	        oneOf(values).getValue(2, column); will(returnValue(4.5));
	     }});
	    
	    Double result = DataUtilities.calculateColumnTotal(values, column);
	    assertEquals("The column total should be 0.0", 7.0, result, 0.00001d);
	}
    
    /********************************************************************
     * ******************************************************************
     * * Test Suite: calculateColumnTotal(Values2D, column , validRows) *
     * * Tester: Chris                                                  *
     * ******************************************************************
     ********************************************************************/
	@Test(expected = IllegalArgumentException.class)
    public void calculateColumnTotalWithRowsNullData() {
		final int[] validRows = {0, 1, 2};
		final int column = 1;
		DataUtilities.calculateColumnTotal(null, 0, validRows);
    }
	
	@Test(expected = NullPointerException.class)
	public void calculateColumnTotalWithRowsEmpty() {
    	final int column = 1;
    	final int[] validRows = {};
    	
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
        Double result = DataUtilities.calculateColumnTotal(values, column, validRows);
        assertEquals("The column total should be 0.0", 0.0, result, 0.00001d);
	}
	
	@Test
	public void calculateColumnTotalWithNumOfRowsGreaterThanColumn() {
    	final int column = 1;
    	final int[] validRows = {0, 1, 2, 3};
    	
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

	@Test
	public void calculateTotalWithNumRowsWithNull() {
    	final int column = 1;
    	final int[] validRows = {0, 1, 2};
    	
        mockingContext.checking(new Expectations() {{
 			// Setup 3 rows
 			oneOf(values).getRowCount(); will(returnValue(3));
 			
 			// Setup 3 columns
 			oneOf(values).getColumnCount(); will(returnValue(3));
             
 			// Mocking the behavior for 3 rows and a specific column
             oneOf(values).getValue(0, column); will(returnValue(2.5));
             oneOf(values).getValue(1, column); will(returnValue(null));
             oneOf(values).getValue(2, column); will(returnValue(4.5));
         }});
        double result = DataUtilities.calculateColumnTotal(values, column, validRows);
        assertEquals("The column total should be 7.0", 7.0, result, 0.00001d);
	}
	
    @Test
    public void calculateColumnTotalWithRowsValidInputs() {
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
