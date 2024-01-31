package sandbox;

// JUnit 4
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test cases for Calculator class using JUnit 4
 */
public class SandboxTest {

    @Test
    public void testFindMax() {
        assertEquals(5, Sandbox.findMax(new int[]{1, 3, 5, 4, 2}));
        assertEquals(-1, Sandbox.findMax(new int[]{-3, -1, -4, -2}));
    }

    @Test
    public void testAdd() {
    	assertEquals(5, Sandbox.addNumbers(2, 3));
    }
}
