package sandbox;

// JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

/**
 * Test cases for Calculator class using JUnit 5
 */
public class CalculatorTest {
	@Nested
	class AdditionTests {
		@Test
		void addingTwoPositiveNumbers() {
			assertEquals(5, Calculator.add(2, 3));
		}
		
		@Test
		void addingPositiveAndNegative() {
			assertEquals(1, Calculator.add(3, -2));
		}
	}
	
	@Nested
	class SubtractionTest{
		@Test
		void subtractingTwoPositiveNumbers() {
			assertEquals(5, Calculator.subtract(7, 2));
		}
		
		@Test
		void SubtractingPositiveAndNegative() {
			assertEquals(5, Calculator.subtract(3, -2));
		}
	}
	
	@Test
	@Timeout(value=500, unit=TimeUnit.MILLISECONDS)
	@Tag("addition")
	void testSimpleAdd() {
		assertEquals(5, Calculator.add(2, 3));
	}
	
	@Test
	void testDivideByZeroException() {
		assertThrows(ArithmeticException.class, () -> {
			Calculator.divide(10, 0);
		});
	}
}
