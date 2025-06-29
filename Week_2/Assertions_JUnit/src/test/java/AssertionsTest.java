import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        assertEquals(5, 2 + 3, "2 + 3 should equal 5");
        assertTrue(5 > 3, "5 is greater than 3");
        assertFalse(5 < 3, "5 is not less than 3");
        assertNull(null, "Expected value to be null");
        assertNotNull(new Object(), "Object should not be null");
    }
}
