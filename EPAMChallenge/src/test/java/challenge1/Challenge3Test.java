package challenge1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class Challenge3Test {
    @Test
    public void testGame() {
        assertEquals(5, Challenge3.countBits(1234));
        assertEquals(1, Challenge3.countBits(4));
        assertEquals(3, Challenge3.countBits(7));
        assertEquals(2, Challenge3.countBits(9));
        assertEquals(2, Challenge3.countBits(10));
    }
}