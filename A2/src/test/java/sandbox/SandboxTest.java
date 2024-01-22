package sandbox;

import static org.junit.Assert.*;
import org.junit.Test;

public class SandboxTest {

    @Test
    public void testFindMax() {
        assertEquals(5, Sandbox.findMax(new int[]{1, 3, 5, 4, 2}));
        assertEquals(-1, Sandbox.findMax(new int[]{-3, -1, -4, -2}));
    }

}