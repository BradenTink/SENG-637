package org.jfree.data.test;

import org.jfree.data.Values2D;
import org.jfree.data.DataUtilities;

import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataUtilitiesTestRowTotal {
	private Mockery context;
	
	@Before
	public void setUp() {
		context = new Mockery();
	}
	
	@Test
	public void testCalculateRowTotalWithValidData() {
		final Values2D values = context.mock(Values2D.class);
		context.checking(new Expectations() {{
			// Assuming there are 2 rows
			oneOf(values).getRowCount();
			will(returnValue(2));
			
			// Assuming each row has 4 columns
			oneOf(values).getColumnCount();
			will(returnValue(3));
			
			// (0, 0) value
			atLeast(1).of(values).getValue(0, 0);
			will(returnValue(1.0));
			
			// (0, 1) value
			atLeast(1).of(values).getValue(0, 1);
			will(returnValue(2.0));
			
			// (0, 2) value
			atLeast(1).of(values).getValue(0, 2);
			will(returnValue(3.0));
			
			double result = DataUtilities.calculateColumnTotal(values, 0);
			assertEquals("The row total should be 6.0", 6.0, result, 0.00001d);
			
			context.assertIsSatisfied();
			}});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowTotalWithNullData() {
	    DataUtilities.calculateRowTotal(null, 0);
	}
	
	@Test
	public void testCalculateRowWithInvalidRow() {
	    final Values2D values = context.mock(Values2D.class);
	    context.checking(new Expectations() {{
	        // Add one row
	        oneOf(values).getRowCount();
	        will(returnValue(1));
	    }});

	    double result = DataUtilities.calculateRowTotal(values, 1);
	    assertEquals("The row total should be 0.0 for an invalid row", 0.0, result, 0.00001d);
	    context.assertIsSatisfied();
	}
	
	@After
	public void tearDown() {
		context.assertIsSatisfied();
		
	}
}
