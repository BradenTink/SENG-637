

package sandbox;

// JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
}
